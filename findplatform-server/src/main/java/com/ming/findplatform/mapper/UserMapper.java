package com.ming.findplatform.mapper;

import com.ming.findplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName :UserMapper
 * @Description :用户部分的mapper
 * @Author :Mox
 * @Date :2021/11/14 17:40
 * @Version : v2.0
 **/

@Mapper
public interface UserMapper {
    /**
     * @Description 插入1条用户数据
     * @param user
     * @return int
     */
    int addUser(User user);

    /**
     * @Description 更新1条用户数据
     * @param user
     * @return int
     */
    int updateUser(User user);

    /**
     * @Description ID删除1条用户数据
     * @param id
     * @return int
     */
    int deleteUserById(String id);

    /**
     * @Description ID查询1条用户数据
     * @param id
     * @return User user
     */
    User getUserById(String id);

    /**
     * @Description 查询所有用户数据
     * @return User users
     */
    List<User> getAllUser();
}
