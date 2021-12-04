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
 * @Version : v1.1.2
 **/


/**
 * 响应的请求域为：/usr
 * 获取数据的使用方法一律为：get
 * 增、删、改的使用方法为：set
 */
@RestController
public class UserController {
    @Resource(name = "user")
    private UserService userService;

    @PostMapping("/usr/userAdd")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/usr/updateUser")
    public int updateAuth(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @PostMapping(value = "/usr/deleteUser/{id}")
    public int deleteUserById(@PathVariable(name = "id") String id) {
        // 删除数据
        return userService.deleteUserById(id);
    }
    @GetMapping(value = "/usr/queryUser")
    public User getAuthById(@RequestParam(value = "id") String id) {
        // 查询单条数据
        User user4 = userService.getUserById(id);
        System.out.println("查询1条数据>>>" + user4.toString());
        return user4;
    }
    @GetMapping("/usr/allUser")
    public List<User> getAllUser() {
        // 查询多条数据
        List<User> users = userService.getAllUser();
        System.out.println("查询多条数据>>>" + users);
        return users;
    }

}
