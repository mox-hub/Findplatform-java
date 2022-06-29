package com.ming.findplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.findplatform.mapper.ItemMapper;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.service.CollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :CollectServiceImpl
 * @Description :收藏部分的CollectService接口实现
 * @Author :Mox
 * @Date :2022/3/26 15:51
 * @Version : v1.0
 **/

@Service("collect")
public class CollectServiceImpl implements CollectService {
    @Resource
    private ItemMapper itemMapper;
    /**
     * @Description 插入1条收藏物品数据
     * @param item
     * @return int i1
     */

    //  配置logger
    private final static Logger logger = LoggerFactory.getLogger(CollectServiceImpl.class);

    @Override
    public int addItem(Item item) {
        int info = itemMapper.insert(item);
        logger.info("[findPlatform] CollectService::插入一条收藏物品数据 >>>" + info);
        return info;
    }
    /**
     * @Description ID删除1条收藏物品数据
     * @param id
     * @return int i3
     */
    @Override
    public int deleteItemById(String id) {
        int info = itemMapper.deleteById(id);
        logger.info("[findPlatform] CollectService::删除一条收藏物品数据 >>>" + info);
        return info;
    }
    /**
     * @Description Tag查询所有Tag收藏物品数据
     * @param tag
     * @return item[] items
     */
    @Override
    public List<Item> getItemByTag(String tag) {
        QueryWrapper<Item> wrapper = new QueryWrapper<>();
        wrapper.eq("tag",tag);
        List<Item> items = itemMapper.selectList(wrapper);
        logger.info("[findPlatform] CollectService::Tag查询收藏物品数据 >>>" + items);
        return items;
    }
    /**
     * @Description 查询所有收藏物品数据
     * @return item[] items
     */
    @Override
    public List<Item> getAllItem() {
        List<Item> items = itemMapper.selectList(null);
        logger.info("[findPlatform] CollectService::查询所有收藏物品数据 >>>" + items);
        return items;
    }
}
