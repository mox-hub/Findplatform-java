package com.ming.findplatform.service.impl;

import com.ming.findplatform.mapper.TagMapper;
import com.ming.findplatform.model.Response;
import com.ming.findplatform.model.Tag;
import com.ming.findplatform.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :TagServiceImpl
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 19:51
 * @Version : v1.0
 **/
@Service("tag")
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    //  配置logger
    private final static Logger logger = LoggerFactory.getLogger(PublishServiceImpl.class);

    @Override
    public Object getAllTag() {
        try {
            List<Tag> tags = tagMapper.selectList(null);
            logger.info("[findPlatform]<v2> TagService:: >>>" + tags);
            return new Response<>(tags);
        } catch (NullPointerException e) {
            Response<Object> response = new Response<>(-1, "未查询到Tag！");
            logger.warn("[findPlatform]<v2> TagService::>>> 查询失败！"+ response);
            return response;
        }
    }
}
