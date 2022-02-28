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
 * @Description :
 * @Author :Mox
 * @Date :2022/2/28 10:27
 * @Version : v1.0
 **/

@Service("http")
public class httpServiceImpl implements HttpService {
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public String getItemInfo(String imgUrl) {
        String url = "127.0.0.1:9011?imgUrl="+imgUrl;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strBody = restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody();
        Item itemResponse = JSONObject.parseObject(strBody,Item.class);

        return strBody;
    }
}
