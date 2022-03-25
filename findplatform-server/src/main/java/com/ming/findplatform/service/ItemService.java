package com.ming.findplatform.service;

import com.ming.findplatform.model.Item;

import java.util.List;

public interface ItemService {
    // 添加数据方法
    int addItem(Item item);

    //  更新更改数据的方法
    int updateItem(Item item);

    // 删除数据
    int deleteItemById(String itemId);

    // 获取数据
    Item getItemById(String itemId);

    List<Item> getItemByTag(String tag);

    List<Item> getAllItem();

    //TODO:v0.3.0添加时间范围检索
//    List<Item> getItemByTime(Date start,Date end);
}
