package com.ming.findplatform.mapper;

import com.ming.findplatform.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName :CollectMapper
 * @Description :Collect对应mapper类
 * @Author :Mox
 * @Date :2022/3/26 15:51
 * @Version : v1.1
 **/

@Mapper
public interface CollectMapper {
    /**
     * @Description 插入1条物品数据
     * @param item
     * @return int i1
     */
    int addItem(Item item);

    /**
     * @Description ID删除1条物品数据
     * @param itemId
     * @return int i3
     */
    int deleteItemById(String itemId);

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

}
