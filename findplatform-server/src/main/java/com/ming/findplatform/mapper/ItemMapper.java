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
