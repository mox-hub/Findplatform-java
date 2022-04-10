package com.ming.findplatform.controller;

import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.QiNiu;
import com.ming.findplatform.service.HttpService;
import com.ming.findplatform.service.ItemService;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName :ImgController
 * @Description :七牛云响应token的发放，与python后台的图片识别链接
 * @Author :Mox
 * @Date :2021/11/15 17:51
 * @Version : v1.1 接口版本v1
 **/

/**
 * 响应的请求域为：/img
 * 查[获取数据]的使用方法一律为：get
 * 增、删、改的使用方法为：post
 */
@RestController
public class ImgController {
    @Resource(name = "http")
    private HttpService httpService;

    /**
     * @Description 从 七牛云 后台获取图片链接
     * @return String qiNiu
     */
    @RequestMapping(value = "/img/v1/getToken", method = RequestMethod.GET)
    public QiNiu getToken() {
        QiNiu qiNiu = new QiNiu();
        // 七牛云图床的秘钥
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

    /**
     * @Description 从 python 后台获取图片识别结果
     * @param imgUrl
     * @return String strBody
     */
    @GetMapping("/img/v1/getItemInfo")
    public String getItemInfo(@RequestParam(value = "imgUrl")String imgUrl) {
        return httpService.getItemInfo(imgUrl);
    }
}
