package com.ming.findplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.ming.findplatform.model.WxRequestRes;
import com.ming.findplatform.utils.WechatDecryptDataUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static com.ming.findplatform.config.WXConfig.*;


/**
 * @ClassName :WXLoginController
 * @Description :
 * @Author :Mox
 * @Date :2022/4/8 10:06
 * @Version : v1.0
 **/

@RestController
public class WXLoginController {
    @GetMapping("/wxLogin/v1/getSessionKey")
    @ResponseBody
    public synchronized Object getSessionKey(String jscode,String checkCode) {
        WxRequestRes res = new WxRequestRes();
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
            return jsonObject;
        } catch (IOException e) {
            System.out.println("encryptedData，decode失败！"+ e);
            res.setCode(-1);
            res.setMsg("获取sessionkey失败！");
            return res;
        }
    }

    @GetMapping("/wxLogin/v1/getPhoneNumber")
    @ResponseBody
    public synchronized Object getPhone(String encryptedData, String iv, String sessionKey,String checkCode) {
        WxRequestRes res = new WxRequestRes();
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
            System.out.println("encryptedData，decode失败！"+ e);
            return res;
        }
        return WechatDecryptDataUtil.decryptData(encryptedData, sessionKey, iv);
    }
}
