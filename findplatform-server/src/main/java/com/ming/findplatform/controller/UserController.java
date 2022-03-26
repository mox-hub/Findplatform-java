package com.ming.findplatform.controller;

import com.ming.findplatform.model.User;
import com.ming.findplatform.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @ClassName :UserController
 * @Description :用户部分的controller
 * @Author :Mox
 * @Date :2021/11/14 17:25
 * @Version : v1.2.1 接口版本v1
 **/

/**
 * 响应的请求域为：/usr
 * 查[获取数据]的使用方法一律为：get
 * 增、删、改的使用方法为：post
 */
@RestController
public class UserController {

    @Resource(name = "user")
    private UserService userService;

    /**
     * @Description 插入1条用户数据
     * @param user
     * @return int
     */
    @PostMapping("/usr/v1/addUser")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * @Description 更新1条用户数据
     * @param user
     * @return int
     */
    @PostMapping("/usr/v1/updateUser")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * @Description ID删除1条用户数据
     * @param id
     * @return int
     */
    @PostMapping(value = "/usr/v1/deleteUser/{id}")
    public int deleteUserById(@PathVariable(name = "id") String id) {
        return userService.deleteUserById(id);
    }

    /**
     * @Description ID查询1条用户数据
     * @param id
     * @return User user
     */
    @GetMapping(value = "/usr/v1/queryUser")
    public User getUserById(@RequestParam(value = "id") String id) {
        User user4 = userService.getUserById(id);
        return user4;
    }

    /**
     * @Description 查询所有用户数据
     * @return User users
     */
    @GetMapping("/usr/v1/allUser")
    public List<User> getAllUser() {
        List<User> users = userService.getAllUser();
        return users;
    }
}
