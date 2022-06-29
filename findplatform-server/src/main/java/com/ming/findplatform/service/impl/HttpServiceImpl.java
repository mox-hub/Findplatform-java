package com.ming.findplatform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ming.findplatform.model.RequestRes;
import com.ming.findplatform.service.HttpService;
import com.ming.findplatform.utils.WechatDecryptDataUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;

import static com.ming.findplatform.config.WXConfig.*;

/**
 * @ClassName :httpServiceImpl
 * @Description :与python后台通信部分的httpService实现
 * @Author :Mox
 * @Date :2022/2/28 10:27
 * @Version : v1.0
 **/
//TODO:该部分仍未验证与python的链接，在0.6.0前完成
@Service("http")
public class HttpServiceImpl implements HttpService {

    //  配置logger
    private final static Logger logger = LoggerFactory.getLogger(HttpServiceImpl.class);

    /**
     * @Description 从 python 后台获取图片识别结果
     * @param imgUrl
     * @return String strBody
     */
    @Override
    public String getItemInfo(String imgUrl) {
        String serverName = "127.0.0.1";    //address
        int port = 9011;    //port
        String result = null;
        try {
            logger.info(imgUrl);
            logger.info("[findPlatform] httpService::连接到主机 >>>" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);   //创建一个socket类
            logger.info("[findPlatform] httpService::远程主机地址 >>>" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(imgUrl);
            InputStream inFromServer = client.getInputStream();

            BufferedReader inRead = new BufferedReader(new InputStreamReader(inFromServer));
            result = inRead.readLine(); // result里存放识别结果
            logger.info("[findPlatform] httpService::服务器响应数据 >>>" + result);
            client.close();

        }catch(IOException e) {
            logger.warn(String.valueOf(e));
        }
        return result;
    }

    /**
     * @Description 通过jscode 从微信后台获取 session_key 和 openid
     * @param jscode
     * @param checkCode
     * @return
     */
    @Override
    public Object getSessionKey(String jscode,String checkCode) {
        RequestRes res = new RequestRes();
        if(StringUtils.isBlank(checkCode)) {
            res.setCode(-1);
            res.setMsg("鉴权失败！");
            return res;
        }

        if(!checkCode.equals("sign")) {
            res.setCode(-1);
            res.setMsg("鉴权失败！");
            return res;
        }

        if(StringUtils.isBlank(checkCode)||checkCode.equals("undefined")) {
            res.setCode(-1);
            res.setMsg("无效参数！");
            return res;
        }

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String requestStr = WX_GET_SESSION_KEY_URL
                +"?appid="+WX_APPID
                +"&secret="+WX_SECRET
                +"&js_code="+jscode
                +"&grant_type=authorization_code";
        Request request = new Request.Builder()
                .url(requestStr)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseStr = response.body().string();
            JSONObject jsonObject = JSONObject.parseObject(responseStr);
            // 获取到session_key
            String session_key = jsonObject.getString("session_key");
            String openid = jsonObject.getString("openid");

            JSONObject result = JSONObject.parseObject(responseStr);

            if(StringUtils.isBlank(session_key)) {
                res.setCode(-1);
                res.setMsg("获取sessionkey失败！");
                return res;
            }
            return result;

        } catch (IOException e) {
            logger.warn("encryptedData，decode失败！"+ e);
            res.setCode(-1);
            res.setMsg("获取sessionkey失败！");
            return res;
        }
    }
    /**
     * @Description getPhoneNumber
     * @param encryptedData
     * @param iv
     * @param sessionKey
     * @param checkCode
     * @return
     */
    @Override
    public Object getPhone(String encryptedData, String iv, String sessionKey,String checkCode) {
        RequestRes res = new RequestRes();
        if(StringUtils.isBlank(checkCode)) {
            res.setCode(-1);
            res.setMsg("鉴权失败！");
            return res;
        }

        if(!checkCode.equals("sign")) {
            res.setCode(-1);
            res.setMsg("鉴权失败！");
            return res;
        }

        if(StringUtils.isBlank(encryptedData)
                ||encryptedData.equals("undefined")
                ||StringUtils.isBlank(iv)
                ||iv.equals("undefined")
                ||StringUtils.isBlank(sessionKey)
                ||sessionKey.equals("undefined")) {
            res.setCode(-1);
            res.setMsg("参数错误！");
            return res;
        }

        // 解码
        try {
            encryptedData = URLDecoder.decode(encryptedData,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            res.setCode(-1);
            res.setMsg("encryptedData，decode失败！");
            logger.warn("[findPlatform] httpService::encryptedData.decode失败！"+ e);
            return res;
        }
        return WechatDecryptDataUtil.decryptData(encryptedData, sessionKey, iv);
    }

}
