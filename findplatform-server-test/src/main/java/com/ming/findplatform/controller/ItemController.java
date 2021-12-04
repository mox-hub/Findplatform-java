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
 * @Version : v1.2
 **/

@RestController
public class ItemController {
    @Resource(name = "item")
    private ItemService itemService;

    @PostMapping("/item/addItem")
    public int addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PostMapping("/item/updateItem")
    public int updateAuth(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @PostMapping(value = "/item/deleteItem/{item_id}")
    public int deleteUserById(@PathVariable(name = "item_id") String id) {
        // 删除数据
        return itemService.deleteItemById(id);
    }

    @GetMapping(value = "/item/queryItem/id")
    public Item getItemById(@RequestParam(value = "item_id") String id) {
        // 查询单条数据
        Item item = itemService.getItemById(id);
        return item;
    }

    @GetMapping(value = "/item/queryItem/tag")
    public List<Item> getItemByTag(@RequestParam(value = "tag") String tag) {
        // 查询单条数据
        List<Item> items = itemService.getItemByTag(tag);
        return items;
    }

    @GetMapping("/item/allItem")
    public List<Item> getAllItem() {
        // 查询多条数据
        List<Item> items = itemService.getAllItem();
        return items;
    }

}
