package com.ming.findplatform.controller;

import com.ming.findplatform.model.QiNiu;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :ImgController
 * @Description :七牛云响应token的发放
 * @Author :Mox
 * @Date :2021/11/15 17:51
 * @Version : v1.0
 **/

@RestController
public class ImgController {
    @RequestMapping(value = "/img/getToken", method = RequestMethod.GET)
    public QiNiu getToken() {
        QiNiu qiNiu = new QiNiu();

        String accessKey = "oSgZW4xW6wLuys8Eib4pPs44OgQ4ihkJrn9aurMt";
        String secretKey = "EPGQHXZO62Jy1dHfQcTJPozDcnrlGR0Ss04g9WPc";
        String bucket = "moxhub";

        long expireSeconds = 3600;   //过期时间
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);

        String upToken = auth.uploadToken(bucket,null, expireSeconds,putPolicy);
        qiNiu.setUptoken(upToken);
        return qiNiu;
    };
}
