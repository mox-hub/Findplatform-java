package com.ming.findplatform.service;

import com.ming.findplatform.model.Item;
import java.util.List;

/**
 * @InterfaceName :ItemService
 * @Description :物品部分的ItemService接口
 * @Author :Mox
 * @Date :2021/11/14 17:17
 * @Version : v2.0
 **/
public interface ItemService {

    String newItemId();

    /**
     * @Description 插入1条物品数据
     * @param item
     * @return int i1
     */
    int addItem(Item item);

    /**
     * @Description 更新1条物品数据
     * @param item
     * @return int i2
     */
    int updateItem(Item item);

    /**
     * @Description ID删除1条物品数据
     * @param itemId
     * @return int i3
     */
    int deleteItemById(String itemId);

    /**
     * @Description ID查询1条物品数据
     * @param itemId
     * @return Item item1
     */
    Item getItemById(String itemId);

    /**
     * @Description Tag查询所有Tag物品数据
     * @param tag
     * @return item[] items
     */
    List<Item> getItemByTag(String tag);

    /**
     * @Description 查询所有物品数据
     * @return item[] items
     */
    List<Item> getAllItem();

    //TODO:v0.5.0添加时间范围检索
//    List<Item> getItemByTime(Date start,Date end);
}
