package com.ming.findplatform.service.impl;

import com.ming.findplatform.mapper.UserMapper;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :UserServiceImpl
 * @Description :用户部分的UserService实现
 * @Author :Mox
 * @Date :2021/11/14 17:17
 * @Version : v2.0
 **/

@Service("user")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * @Description 插入1条用户数据
     * @Method POST
     * @return id i1
     */
    @Override
    public int addUser(User user){
        int i1 = userMapper.addUser(user);
        System.out.println("[findPlatform] UserService::插入1条用户数据 >>>" + i1);
        return i1;
    }

    /**
     * @Description 更新1条用户数据
     * @Method POST
     * @return id i2
     */
    @Override
    public int updateUser(User user){
        // 修改数据
        int i2 = userMapper.updateUser(user);
        System.out.println("[findPlatform] UserService::更新1条用户数据 >>>" + i2);
        return i2;
    }

    /**
     * @Description 删除1条用户数据
     * @Method POST
     * @return id i3
     */
    @Override
    public  int deleteUserById(String id){
        // 删除数据
        int i3 = userMapper.deleteUserById(id);
        System.out.println("[findPlatform] UserService::删除1条用户数据 >>>" + i3);
        return i3;
    }

    /**
     * @Description ID查询1条用户数据
     * @Method GET
     * @return User user
     */
    @Override
    public User getUserById(String id){
        // 查询单条数据
        User user4 = userMapper.getUserById(id);
        System.out.println("[findPlatform] UserService::ID查询1条用户数据 >>>" + user4.toString());
        return user4;
    }

    /**
     * @Description 查询所有用户数据
     * @Method GET
     * @return User[] users
     */
    @Override
    public List<User> getAllUser(){
        List<User> users = userMapper.getAllUser();
        System.out.println("[findPlatform] UserService::查询所有用户数据 >>>" + users);
        return users;
    }
}
