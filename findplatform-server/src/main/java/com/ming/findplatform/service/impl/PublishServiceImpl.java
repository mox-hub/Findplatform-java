package com.ming.findplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.findplatform.mapper.ItemMapper;
import com.ming.findplatform.mapper.UserMapper;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.Response;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.PublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :PublishServiceImpl
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 19:37
 * @Version : v1.0
 **/
@Service("publish")
public class PublishServiceImpl implements PublishService {

    @Resource
    private ItemMapper itemMapper;

    //  配置logger
    private final static Logger logger = LoggerFactory.getLogger(PublishServiceImpl.class);

    @Override
    public Object getUserPublish(String userId) {
        try {
            QueryWrapper<Item> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",userId);
            List<Item> items = itemMapper.selectList(wrapper);
            logger.info("[findPlatform][v2版本] PublishService::openID查询1条用户数据 >>>" + items);
            return new Response<>(items);
        } catch (NullPointerException e) {
            Response<Object> response = new Response<>(-1, "未查询到用户！");
            logger.warn("[findPlatform][v2版本] PublishService::openID查询1条用户数据 >>> 查询失败！"+ response);
            return response;
        }
    }

    @Override
    public Object deletePublishById(String id) {
        try {
            int res = itemMapper.deleteById(id);
            logger.info("[findPlatform][v2版本] PublishService::openID查询1条用户数据 >>>" + res);
            return new Response<>(res);
        } catch (NullPointerException e) {
            Response<Object> response = new Response<>(-1, "未查询到用户！");
            logger.warn("[findPlatform][v2版本] PublishService::openID查询1条用户数据 >>> 查询失败！"+ response);
            return response;
        }
    }
}
