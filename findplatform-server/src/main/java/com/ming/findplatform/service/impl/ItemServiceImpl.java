package com.ming.findplatform.service.impl;

import com.ming.findplatform.mapper.ItemMapper;
import com.ming.findplatform.mapper.UserMapper;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * @Description 获取新生成的物品ID
     * @Method GET
     * @return id
     */
    @Override
    public String newItemId() {
        String id="";
        //获取当前时间戳
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String temp = sf.format(new Date());
        //获取6位随机数
        int random=(int)((Math.random()+1)*1000);
        id=temp+random;
        System.out.println("[findPlatform] ItemService::生成一条新的物品ID >>>" + id);
        return id;
    }

    /**
     * @Description 插入1条物品数据
     * @param item
     * @return int i1
     */
    @Override
    public int addItem(Item item) {
        int info = itemMapper.addItem(item);
        System.out.println("[findPlatform] ItemService::插入1条物品数据 >>>" + info);
        return info;
    }

    /**
     * @Description 更新1条物品数据
     * @param item
     * @return int i2
     */
    @Override
    public int updateItem(Item item) {
        int info = itemMapper.updateItem(item);
        System.out.println("[findPlatform] ItemService::更新1条物品数据 >>>" + info);
        return info;
    }

    /**
     * @Description ID删除1条物品数据
     * @param id
     * @return int i3
     */
    @Override
    public int deleteItemById(String id) {
        int info = itemMapper.deleteItemById(id);
        System.out.println("[findPlatform] ItemService::ID删除1条物品数据 >>>" + info);
        return info;
    }

    /**
     * @Description ID查询1条物品数据
     * @param id
     * @return Item item1
     */
    @Override
    public Item getItemById(String id) {
        Item item = itemMapper.getItemById(id);
        System.out.println("[findPlatform] ItemService::ID查询1条物品数据 >>>" + item.toString());
        return item;
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
