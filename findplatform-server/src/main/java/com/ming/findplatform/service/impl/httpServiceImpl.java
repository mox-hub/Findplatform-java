package com.ming.findplatform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.service.HttpService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName :httpServiceImpl
 * @Description :与python后台通信部分的httpService实现
 * @Author :Mox
 * @Date :2022/2/28 10:27
 * @Version : v1.0
 **/

//TODO:该部分仍未验证与python的链接，在0.6.0前完成
@Service("http")
public class httpServiceImpl implements HttpService {
    RestTemplate restTemplate = new RestTemplate();
    
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
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);   //创建一个socket类
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(imgUrl + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();

            BufferedReader inRead = new BufferedReader(new InputStreamReader(inFromServer));
            result = inRead.readLine(); // result里存放识别结果
            System.out.println("服务器响应" + result);

//            DataInputStream in = new DataInputStream(inFromServer);
//            System.out.println(in.);
//            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)        {
            e.printStackTrace();
        }
        return result;
    }
}
