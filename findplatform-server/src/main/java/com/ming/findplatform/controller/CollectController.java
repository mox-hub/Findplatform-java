package com.ming.findplatform.controller;

import com.ming.findplatform.model.Item;
import com.ming.findplatform.service.CollectService;
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

@RestController
public class CollectController {
    @Resource(name = "collect")
    private CollectService collectService;

    @PostMapping("/collect/v1/addItem")
    public int addItem(@RequestBody Item item) {
        return collectService.addItem(item);
    }

    @PostMapping(value = "/collect/v1/deleteItem/{item_id}")
    public int deleteUserById(@PathVariable(name = "item_id") String id) {
        return collectService.deleteItemById(id);
    }

    @GetMapping(value = "/collect/v1/queryItem/tag")
    public List<Item> getItemByTag(@RequestParam(value = "tag") String tag) {
        List<Item> items = collectService.getItemByTag(tag);
        return items;
    }

    @GetMapping("/collect/v1/allItem")
    public List<Item> getAllItem() {
        List<Item> items = collectService.getAllItem();
        return items;
    }
}
