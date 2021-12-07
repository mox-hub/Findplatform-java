package com.ming.findplatform.controller;

import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :ItemController
 * @Description :
 * @Author :Mox
 * @Date :2021/11/19 10:07
 * @Version : v1.2.1 接口版本v1
 **/

@RestController
public class ItemController {
    @Resource(name = "item")
    private ItemService itemService;

    @PostMapping("/item/v1/addItem")
    public int addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PostMapping("/item/v1/updateItem")
    public int updateAuth(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @PostMapping(value = "/item/v1/deleteItem/{item_id}")
    public int deleteUserById(@PathVariable(name = "item_id") String id) {
        // 删除数据
        return itemService.deleteItemById(id);
    }

    @GetMapping(value = "/item/v1/queryItem/id")
    public Item getItemById(@RequestParam(value = "item_id") String id) {
        // 查询单条数据
        Item item = itemService.getItemById(id);
        return item;
    }

    @GetMapping(value = "/item/v1/queryItem/tag")
    public List<Item> getItemByTag(@RequestParam(value = "tag") String tag) {
        // 查询单条数据
        List<Item> items = itemService.getItemByTag(tag);
        return items;
    }

    @GetMapping("/item/v1/allItem")
    public List<Item> getAllItem() {
        // 查询多条数据
        List<Item> items = itemService.getAllItem();
        return items;
    }

}
