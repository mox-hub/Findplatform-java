package com.ming.findplatform.service;

import com.ming.findplatform.model.Collect;
import com.ming.findplatform.model.Item;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @InterfaceName :CollectService
 * @Description :收藏部分的CollectService接口
 * @Author :Mox
 * @Date :2021/11/14 17:17
 * @Version : v1.0
 **/

public interface CollectService {
    /**
     * @Description 插入1条收藏物品数据
     * @param item
     * @return int i1
     */
    int addItem(Item item);

    /**
     * @Description ID删除1条收藏物品数据
     * @param itemId
     * @return int i3
     */
    int deleteItemById(String itemId);

    /**
     * @Description Tag查询所有Tag收藏物品数据
     * @param tag
     * @return item[] items
     */
    List<Item> getItemByTag(String tag);

    /**
     * @Description 查询所有收藏物品数据
     * @return item[] items
     */
    List<Item> getAllItem();

    Object addCollect(Collect collect);

    Object deleteCollectById(String id);

    Object getCollectByUId(String uid);

    Object getAllCollect();
}
