package com.ming.findplatform.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName :User
 * @Description :用户数据的实体类
 * @Author :Mox
 * @Date :2021/11/14 17:02
 * @Version : v3.0
 * v2.0新添加phone_number
 **/

//TODO:解决phoneNumber为null的问题
@TableName(value = "user")
public class User {
    @TableId(type = IdType.INPUT)
    private String id;
    private String openid;
    private String avatarUrl;
    private String username;
    private String password;
    private String college;
    private String phoneNumber;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", openid='" + openid + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", college='" + college + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
