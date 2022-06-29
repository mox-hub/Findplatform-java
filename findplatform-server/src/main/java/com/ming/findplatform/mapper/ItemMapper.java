package com.ming.findplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ItemMapper extends BaseMapper<Item> {
    //TODO:v0.7.0添加时间范围检索
}
