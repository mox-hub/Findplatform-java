package com.ming.findplatform.mapper;

import com.ming.findplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName :UserMapper
 * @Description :用户部分的mapper
 * @Author :Mox
 * @Date :2021/11/14 17:40
 * @Version : v1.0
 **/

@Mapper
public interface UserMapper {

    int addUser(User user);

    int updateUser(User user);

    int deleteUserById(String id);

    User getUserById(String id);

    List<User> getAllUser();

}
