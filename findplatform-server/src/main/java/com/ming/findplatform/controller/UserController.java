package com.ming.findplatform.controller;

import com.ming.findplatform.model.User;
import com.ming.findplatform.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @ClassName :UserController
 * @Description :用户部分的controller
 * @Author :Mox
 * @Date :2021/11/14 17:25
 * @Version : v2.0.0 接口版本v1
 **/

/**
 * 响应的请求域为：/usr
 * 查[获取数据]的使用方法一律为：get
 * 增、删、改的使用方法为：post
 */
@Api(tags = "[User]用户管理")
@RestController
public class UserController {

    @Resource(name = "user")
    private UserService userService;

    @GetMapping("/usr/v2/newUserId")
    @ApiOperation("[newUserId]获取新的用户id")
    public String newUserId() {
        return userService.newUserId();
    }

    /**
     * @Description 插入1条用户数据
     * @param user
     * @return int
     */

    @PostMapping("/usr/v1/addUser")
    @ApiOperation("[addUser]添加新的用户")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * @Description ID删除1条用户数据
     * @param id
     * @return int
     */
    @PostMapping(value = "/usr/v1/deleteUser/{id}")
    @ApiOperation("[addUser]添加新的用户")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1111", required = true)
    public int deleteUserById(@PathVariable(name = "id") String id) {
        return userService.deleteUserById(id);
    }

    /**
     * @Description 更新1条用户数据
     * @param user
     * @return int
     */
    @PostMapping("/usr/v1/updateUser")
    @ApiOperation("[updateUser]更新用户数据")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * @Description openID查询1条用户数据
     * @param openid
     * @return User user
     */
    @GetMapping(value = "/usr/v1/queryUser/openid")
    @ApiOperation("[getUserByOpenId]通过Openid查询用户")
    @ApiImplicitParam(name = "openid", value = "用户openid", defaultValue = "1111", required = true)
    public User getUserByOpenId(@RequestParam(value = "openid") String openid) {
        User user = userService.getUserByOpenId(openid);
        return user;
    }

    /**
     * @Description ID查询1条用户数据
     * @param id
     * @return User user
     */
    @GetMapping(value = "/usr/v1/queryUser")
    @ApiOperation("[getUserById]通过id查询用户")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1111", required = true)
    public User getUserById(@RequestParam(value = "id") String id) {
        User user = userService.getUserById(id);
        return user;
    }

    /**
     * @Description 查询所有用户数据
     * @return User users
     */
    @GetMapping("/usr/v1/allUser")
    @ApiOperation("[getAllUser]查询用户列表")
    public List<User> getAllUser() {
        List<User> users = userService.getAllUser();
        return users;
    }

    /**
     * @Description openID查询1条用户数据
     * @param openid
     * @return User user
     */
    @GetMapping(value = "/usr/v2/queryUser/openid")
    @ApiOperation("[getUserByOpenIdv2]查询用户列表")
    @ApiImplicitParam(name = "openid", value = "用户openid", defaultValue = "1111", required = true)
    public Object getUserByOpenIdv2(@RequestParam(value = "openid") String openid) {
        Object res = userService.getUserByOpenIdv2(openid);
        return res;
    }


}
