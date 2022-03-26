package com.ming.findplatform.model;

/**
 * @ClassName :User
 * @Description :用户数据的实体类
 * @Author :Mox
 * @Date :2021/11/14 17:02
 * @Version : v3.0
 * v2.0新添加phone_number
 **/

//TODO:解决phoneNumber为null的问题
public class User {
    private String id;
    private String username;
    private String password;
    private String college;
    private String phoneNumber;

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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", college='" + college + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
