package com.ming.findplatform.controller;

import com.ming.findplatform.service.HttpService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @ClassName :WXLoginController
 * @Description :
 * @Author :Mox
 * @Date :2022/4/8 10:06
 * @Version : v1.0
 **/

@Api(tags = "[wxLogin]微信登录管理")
@RestController
public class WXLoginController {

    @Resource(name = "http")
    private HttpService httpService;

    /**
     * @Description 通过jscode 从微信后台获取 session_key 和 openid
     * @param jscode
     * @param checkCode
     * @return
     */
    @ResponseBody
    @GetMapping("/wxLogin/v1/getSessionKey")
    public synchronized Object getSessionKey(String jscode,String checkCode) {
        Object sessionKey = httpService.getSessionKey(jscode, checkCode);
        return sessionKey;
    }

    //TODO：弃用接口 getPhoneNumber
    /**
     * @Description getPhoneNumber
     * @param encryptedData
     * @param iv
     * @param sessionKey
     * @param checkCode
     * @return
     */
    @ResponseBody
    @GetMapping("/wxLogin/v1/getPhoneNumber")
    public synchronized Object getPhone(String encryptedData, String iv, String sessionKey,String checkCode) {
        Object phone = httpService.getPhone(encryptedData, iv, sessionKey, checkCode);
        return phone;
    }
}
