package com.ming.findplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ming.findplatform.model.Collect;
import com.ming.findplatform.model.VO.CollectVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;


/**
 * @InterfaceName :CollectMapper
 * @Description :Collect对应mapper类
 * @Author :Mox
 * @Date :2022/3/26 15:51
 * @Version : v1.1
 **/

@Mapper
public interface CollectMapper extends BaseMapper<Collect> {
    @Select("SELECT collect.*,item_list.* FROM collect,item_list WHERE collect.item_id=item_list.item_id")
    List<CollectVO> getAllCollectVO();

    @Select("SELECT collect.*,item_list.* FROM collect,item_list WHERE collect.item_id=item_list.item_id AND "+"collect.collect_uid= #{uid}")
    List<CollectVO> getCollectByUid( @Param("uid")String uid);
}
