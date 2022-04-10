package com.ming.findplatform.service;

import com.ming.findplatform.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @InterfaceName :UserService
 * @Description :用户部分的UserService接口
 * @Author :Mox
 * @Date :2021/11/14 17:17
 * @Version : v2.0
 **/

public interface UserService {

    String newUserId();

    /**
     * @Description 插入1条用户数据
     * @param user
     * @return int
     */
    int addUser(User user);

    /**
     * @Description ID删除1条用户数据
     * @param id
     * @return int
     */
    int deleteUserById(String id);

    /**
     * @Description 更新1条用户数据
     * @param user
     * @return int
     */
    int updateUser(User user);

    /**
     * @Description ID查询1条用户数据
     * @param id
     * @return User user
     */
    User getUserById(String id);

    /**
     * @Description openID查询1条用户数据
     * @param openid
     * @return User user
     */
    User getUserByOpenId(String openid);

    /**
     * @Description 查询所有用户数据
     * @return User users
     */
    List<User> getAllUser();

    Object getUserByOpenIdv2(String openid);
}
