package com.ming.findplatform.controller;

import com.ming.findplatform.model.Item;
import com.ming.findplatform.service.PublishService;
import com.ming.findplatform.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :PublishController
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 17:52
 * @Version : v1.0
 **/

@Api(tags = "[Publish]发布管理")
@RestController
@RequestMapping("/publish")
public class PublishController {
    @Resource(name = "publish")
    private PublishService publishService;

    @GetMapping("/v2/getUserPublish")
    @ApiOperation("[getUserPublish]查询用户发布物品")
    public Object getUserPublish(@RequestParam(value = "user_id") String userId) {
        Object res = publishService.getUserPublish(userId);
        return res;
    }

    @PostMapping(value = "/v2/deletePublishById/{item_id}")
    @ApiOperation("[deletePublishById]删除用户发布物品")
    public Object deletePublishById(@RequestParam(name = "item_id") String id) {
        return publishService.deletePublishById(id);
    }
}
