package com.ming.findplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ming.findplatform.model.Item;
import com.ming.findplatform.model.Tag;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName :TagMapper
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 17:51
 * @Version : v1.0
 **/
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}
