package com.ming.findplatform.service;


import org.springframework.web.bind.annotation.RequestParam;

/**
 * @InterfaceName :PublishService
 * @Description :PublishService
 * @Author :Mox
 * @Date :2022/6/29 17:55
 * @Version : v1.0
 **/
public interface PublishService {

    Object getUserPublish(String userId);

    Object deletePublishById(String id);

}
