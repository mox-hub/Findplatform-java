package com.ming.findplatform.mapper;

import com.ming.findplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(String id);
    User getUserById(String id);

    List<User> getAllUser();

}
