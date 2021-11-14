package com.ming.findplatform.controller;

import com.ming.findplatform.model.User;
import com.ming.findplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName :UserController
 * @Description :
 * @Author :Mox
 * @Date :2021/11/14 17:25
 * @Version : v1.0
 **/

@RestController
public class UserController {
    @Resource(name = "user")
    private UserService userService;

    @PostMapping("/userAdd")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/updateUser")
    public int updateAuth(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @PostMapping(value = "/deleteUser/{id}")
    public int deleteUserById(@PathVariable(name = "id") String id) {
        // 删除数据
        return userService.deleteUserById(id);
    }
    @GetMapping(value = "/queryUser")
    public User getAuthById(@RequestParam(value = "id") String id) {
        // 查询单条数据
        User user4 = userService.getUserById(id);
        System.out.println("查询1条数据>>>" + user4.toString());
        return user4;
    }
    @GetMapping("/allUser")
    public List<User> getAllUser() {
        // 查询多条数据
        List<User> users = userService.getAllUser();
        System.out.println("查询多条数据>>>" + users);
        return users;
    }

}
