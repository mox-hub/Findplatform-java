package com.ming.findplatform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.service.HttpService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        String url = "http://127.0.0.1:9011?imgUrl="+imgUrl;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strBody = restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody();
        Item itemResponse = JSONObject.parseObject(strBody,Item.class);

        return strBody;
    }
}
