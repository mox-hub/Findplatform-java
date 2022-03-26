package com.ming.findplatform.service.impl;

import com.ming.findplatform.mapper.ItemMapper;
import com.ming.findplatform.mapper.UserMapper;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :ItemServiceImpl
 * @Description :物品列表部分的ItemService实现
 * @Author :Mox
 * @Date :2021/11/19 10:44
 * @Version : v1.0
 **/

@Service("item")
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;

    /**
     * @Description 插入1条物品数据
     * @param item
     * @return int i1
     */
    @Override
    public int addItem(Item item) {
        int i1 = itemMapper.addItem(item);
        System.out.println("[findPlatform] ItemService::插入1条物品数据 >>>" + i1);
        return i1;
    }

    /**
     * @Description 更新1条物品数据
     * @param item
     * @return int i2
     */
    @Override
    public int updateItem(Item item) {
        int i2 = itemMapper.updateItem(item);
        System.out.println("[findPlatform] ItemService::更新1条物品数据 >>>" + i2);
        return i2;
    }

    /**
     * @Description ID删除1条物品数据
     * @param id
     * @return int i3
     */
    @Override
    public int deleteItemById(String id) {
        int i3 = itemMapper.deleteItemById(id);
        System.out.println("[findPlatform] ItemService::ID删除1条物品数据 >>>" + i3);
        return i3;
    }

    /**
     * @Description ID查询1条物品数据
     * @param id
     * @return Item item1
     */
    @Override
    public Item getItemById(String id) {
        Item item1 = itemMapper.getItemById(id);
        System.out.println("[findPlatform] ItemService::ID查询1条物品数据 >>>" + item1.toString());
        return item1;
    }

    /**
     * @Description Tag查询所有Tag物品数据
     * @param tag
     * @return item[] items
     */
    @Override
    public List<Item> getItemByTag(String tag) {
        List<Item> items = itemMapper.getItemByTag(tag);
        System.out.println("[findPlatform] ItemService::Tag查询所有Tag物品数据 >>>" + items);
        return items;
    }

    /**
     * @Description 查询所有物品数据
     * @return item[] items
     */
    @Override
    public List<Item> getAllItem() {
        List<Item> items = itemMapper.getAllItem();
        System.out.println("[findPlatform] ItemService::查询所有物品数据 >>>" + items);
        return items;
    }
}
