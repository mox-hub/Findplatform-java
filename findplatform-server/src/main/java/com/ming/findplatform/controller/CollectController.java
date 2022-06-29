package com.ming.findplatform.controller;

import com.ming.findplatform.model.Collect;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :CollectController
 * @Description :收藏部分的controller
 * @Author :Mox
 * @Date : 2022/3/26 15:51
 * @Version : v1.2 接口版本v1
 **/
@Api(tags = "[Collect]收藏管理")
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource(name = "collect")
    private CollectService collectService;

    @PostMapping("/v1/addItem")
    @ApiOperation("[addItem]添加收藏物品")
    public int addItem(@RequestBody Item item) {
        return collectService.addItem(item);
    }

    @PostMapping(value = "/v1/deleteItem/{item_id}")
    @ApiOperation("[deleteItemById]删除收藏物品")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "item_id", value = "物品id", defaultValue = "1111", required = true)
    })
    public int deleteItemById(@RequestParam(name = "item_id") String id) {
        return collectService.deleteItemById(id);
    }

    @GetMapping(value = "/v1/queryItem/tag")
    @ApiOperation("[getItemByTag]按Tag查询收藏物品")
    public List<Item> getItemByTag(@RequestParam(value = "tag") String tag) {
        List<Item> items = collectService.getItemByTag(tag);
        return items;
    }

    @GetMapping("/v1/allItem")
    @ApiOperation("[getAllItem]查询全部收藏物品")
    public List<Item> getAllItem() {
        List<Item> items = collectService.getAllItem();
        return items;
    }

    //  v2版本

    @PostMapping("/v2/addCollect")
    @ApiOperation("[addCollect]添加收藏物品")
    public Object addCollect(@RequestBody Collect collect) {
        return collectService.addCollect(collect);
    }

    @PostMapping(value = "/v2/deleteCollectById/{collect_id}")
    @ApiOperation("[deleteCollectById]删除收藏物品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "collect_id", value = "收藏id", defaultValue = "0001", required = true)
    })
    public Object deleteCollectById(@RequestParam(name = "collect_id") String id) {
        return collectService.deleteCollectById(id);
    }

    @GetMapping(value = "/v2/queryItem/uid")
    @ApiOperation("[getItemByTag]按Tag查询收藏物品")
    public Object getCollectByUId(@RequestParam(value = "uid") String uid) {
        return collectService.getCollectByUId(uid);
    }

    @GetMapping("/v2/getAllCollect")
    @ApiOperation("[getAllCollect]查询全部收藏物品")
    public Object getAllCollect() {
        return collectService.getAllCollect();
    }
}
