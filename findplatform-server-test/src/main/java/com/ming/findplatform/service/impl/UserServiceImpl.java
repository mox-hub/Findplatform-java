package com.ming.findplatform.service.impl;

import com.ming.findplatform.mapper.UserMapper;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :UserServiceImpl
 * @Description :
 * @Author :Mox
 * @Date :2021/11/14 17:17
 * @Version : v1.0
 **/

@Service("user")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user){
        int i1 = userMapper.addUser(user);
        System.out.println("UserService::插入一条数据>>>" + i1);
        return i1;
    }
    @Override
    public int updateUser(User user){
        // 修改数据
        int i2 = userMapper.updateUser(user);
        System.out.println("UserService::更新一条数据>>>" + i2);
        return i2;
    }
    @Override
    public  int deleteUserById(String id){
        // 删除数据
        int i3 = userMapper.deleteUserById(id);
        System.out.println("UserService::删除一条数据>>>" + i3);
        return i3;
    }
    @Override
    public User getUserById(String id){
        // 查询单条数据
        User user4 = userMapper.getUserById(id);
        System.out.println("UserService::查询1条数据>>>" + user4.toString());
        return user4;
    }
    @Override
    public List<User> getAllUser(){
        // 查询多条数据
        List<User> users = userMapper.getAllUser();
        System.out.println("UserService::查询多条数据>>>" + users);
        return users;
    }

}
