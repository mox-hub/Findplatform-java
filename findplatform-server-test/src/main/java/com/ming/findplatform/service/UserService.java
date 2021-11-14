package com.ming.findplatform.service;

import com.ming.findplatform.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(String id);
    User getUserById(String id);

    List<User> getAllUser();
}
