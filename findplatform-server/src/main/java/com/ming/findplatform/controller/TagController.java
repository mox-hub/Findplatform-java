package com.ming.findplatform.controller;

import com.ming.findplatform.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName :Tag
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 19:47
 * @Version : v1.0
 **/

@Api(tags = "[Tag]标签管理")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource(name = "tag")
    private TagService tagService;

    /**
     * @Description 查询所有tag数据
     * @return User users
     */
    @GetMapping("/v1/getAllTag")
    @ApiOperation("[getAllTag]查询标签列表")
    public Object getAllTag() {
        Object res = tagService.getAllTag();
        return res;
    }

}
