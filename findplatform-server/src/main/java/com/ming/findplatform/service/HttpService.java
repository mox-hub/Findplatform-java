package com.ming.findplatform.service;

/**
 * @InterfaceName :HttpService
 * @Description :网络通信部分的HttpService接口
 * @Author :Mox
 * @Date :2021/11/14 17:17
 * @Version : v2.0
 **/

public interface HttpService {

    /**
     * @Description 从 python 后台获取图片识别结果
     * @param imgUrl
     * @return String strBody
     */
    String getItemInfo(String imgUrl);
    /**
     * @Description 通过jscode 从微信后台获取 session_key 和 openid
     * @param jscode
     * @param checkCode
     * @return
     */
    Object getSessionKey(String jscode,String checkCode);
    /**
     * @Description getPhoneNumber
     * @param encryptedData
     * @param iv
     * @param sessionKey
     * @param checkCode
     * @return
     */
    Object getPhone(String encryptedData, String iv, String sessionKey,String checkCode);
}
