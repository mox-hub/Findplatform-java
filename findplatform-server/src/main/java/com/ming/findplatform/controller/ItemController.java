package com.ming.findplatform.controller;

import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.ItemService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :ItemController
 * @Description :物品部分的controller
 * @Author :Mox
 * @Date :2021/11/19 10:07
 * @Version : v1.3 接口版本v1
 **/

/**
 * 响应的请求域为：/item
 * 查[获取数据]的使用方法一律为：get
 * 增、删、改的使用方法为：post
 */
@Api(tags = "[Item]物品管理")
@RestController
public class ItemController {
    @Resource(name = "item")
    private ItemService itemService;
    /**
     * @Description 获取新生成的物品ID
     * @Method GET
     * @return id
     */
    @GetMapping("/item/v2/newItemId")
    public String newItemId() {
        return itemService.newItemId();
    }

    /**
     * @Description 插入1条物品数据
     * @param item
     * @return int i1
     */
    @PostMapping("/item/v1/addItem")
    public int addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    /**
     * @Description 更新1条物品数据
     * @param item
     * @return int i2
     */
    @PostMapping("/item/v1/updateItem")
    public int updateAuth(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    /**
     * @Description ID删除1条物品数据
     * @param id
     * @return int i3
     */
    @PostMapping(value = "/item/v1/deleteItem/{item_id}")
    public int deleteUserById(@PathVariable(name = "item_id") String id) {
        // 删除数据
        return itemService.deleteItemById(id);
    }

    /**
     * @Description ID查询1条物品数据
     * @param id
     * @return Item item1
     */
    @GetMapping(value = "/item/v1/queryItem/id")
    public Item getItemById(@RequestParam(value = "item_id") String id) {
        // 查询单条数据
        Item item = itemService.getItemById(id);
        return item;
    }

    /**
     * @Description Tag查询所有Tag物品数据
     * @param tag
     * @return item[] items
     */
    @GetMapping(value = "/item/v1/queryItem/tag")
    public List<Item> getItemByTag(@RequestParam(value = "tag") String tag) {
        // 查询单条数据
        List<Item> items = itemService.getItemByTag(tag);
        return items;
    }

    /**
     * @Description 查询所有物品数据
     * @return item[] items
     */
    @GetMapping("/item/v1/allItem")
    public List<Item> getAllItem() {
        // 查询多条数据
        List<Item> items = itemService.getAllItem();
        return items;
    }
}
