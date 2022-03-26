package com.ming.findplatform.service;

/**
 * @InterfaceName :HttpService
 * @Description :网络通信部分的HttpService接口
 * @Author :Mox
 * @Date :2021/11/14 17:17
 * @Version : v1.0
 **/

public interface HttpService {

    /**
     * @Description 从 python 后台获取图片识别结果
     * @param imgUrl
     * @return String strBody
     */
    String getItemInfo(String imgUrl);
}
