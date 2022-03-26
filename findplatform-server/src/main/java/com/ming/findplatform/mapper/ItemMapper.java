package com.ming.findplatform.mapper;

import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

/**
 * @InterfaceName :ItemMapper
 * @Description :item_list对应mapper类
 * @Author :Mox
 * @Date :2021/11/19 10:09
 * @Version : v1.0
 **/

@Mapper
public interface ItemMapper {
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
