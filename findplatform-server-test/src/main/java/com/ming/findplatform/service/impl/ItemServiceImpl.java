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
 * @Description :
 * @Author :Mox
 * @Date :2021/11/19 10:44
 * @Version : v1.0
 **/

@Service("item")
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;

    @Override
    public int addItem(Item item) {
        int i1 = itemMapper.addItem(item);
        System.out.println("ItemService::插入一条数据>>>" + i1);
        return i1;
    }

    @Override
    public int updateItem(Item item) {
        int i2 = itemMapper.updateItem(item);
        System.out.println("ItemService::删除一条数据>>>" + i2);
        return i2;
    }

    @Override
    public int deleteItemById(String id) {
        int i3 = itemMapper.deleteItemById(id);
        System.out.println("ItemService::删除一条数据>>>" + i3);
        return i3;
    }

    @Override
    public Item getItemById(String id) {
        Item item1 = itemMapper.getItemById(id);
        System.out.println("UserService::查询1条数据>>>" + item1.toString());
        return item1;
    }

    @Override
    public List<Item> getItemByTag(String tag) {
        List<Item> items = itemMapper.getItemByTag(tag);
        System.out.println("UserService::查询tag数据>>>" + items);
        return items;
    }

    @Override
    public List<Item> getAllItem() {
        List<Item> items1 = itemMapper.getAllItem();
        System.out.println("UserService::查询tag数据>>>" + items1);
        return items1;
    }
}
