package com.ming.findplatform.service.impl;

import com.ming.findplatform.mapper.UserMapper;
import com.ming.findplatform.model.Response;
import com.ming.findplatform.model.User;
import com.ming.findplatform.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * @Description 获取新生成的用户ID
     * @Method GET
     * @return id
     */
    @Override
    public String newUserId(){
        String id="";
        //获取当前时间戳
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String temp = sf.format(new Date());
        //获取6位随机数
        int random=(int)((Math.random()+1)*100000);
        id=temp+random;
        System.out.println("[findPlatform] UserService::生成一条新的用户ID >>>" + id);
        return id;
    }

    /**
     * @Description 插入1条用户数据
     * @Method POST
     * @return id i1
     */
    @Override
    public int addUser(User user){
        int info = userMapper.addUser(user);
        System.out.println("[findPlatform] UserService::插入1条用户数据 >>>" + info);
        return info;
    }

    /**
     * @Description 删除1条用户数据
     * @Method POST
     * @return id i3
     */
    @Override
    public  int deleteUserById(String id){
        // 删除数据
        int info = userMapper.deleteUserById(id);
        System.out.println("[findPlatform] UserService::删除1条用户数据 >>>" + info);
        return info;
    }

    /**
     * @Description 更新1条用户数据
     * @Method POST
     * @return id i2
     */
    @Override
    public int updateUser(User user){
        // 修改数据
        int info = userMapper.updateUser(user);
        System.out.println(user.getId());
        User user_after = userMapper.getUserById(user.getId());
        System.out.println("[findPlatform] UserService::更新1条用户数据 >>>" + user_after);
        return info;
    }

    /**
     * @Description ID查询1条用户数据
     * @Method GET
     * @return User user
     */
    @Override
    public User getUserById(String id){
        // 查询单条数据
        User user = userMapper.getUserById(id);
        System.out.println("[findPlatform] UserService::ID查询1条用户数据 >>>" + user.toString());
        return user;
    }

    /**
     * @Description openID查询1条用户数据
     * @Method GET
     * @return User user
     */
    @Override
    public User getUserByOpenId(String openid){
        // 查询单条数据
        User user = userMapper.getUserByOpenId(openid);
        System.out.println("[findPlatform] UserService::openID查询1条用户数据 >>>" + user.toString());
        return user;
    }

    @Override
    public Object getUserByOpenIdv2(String openid){
        // 查询单条数据
        try {
            User user = userMapper.getUserByOpenId(openid);
            System.out.println("[findPlatform][v2版本] UserService::openID查询1条用户数据 >>>" + user.toString());
            return new Response<>(user);
        }catch (NullPointerException e) {
            Response<Object> response = new Response<>(-1, "未查询到用户！");
            System.out.println("[findPlatform][v2版本] UserService::openID查询1条用户数据 >>> 查询失败！"+ response);
            return response;
        }
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
