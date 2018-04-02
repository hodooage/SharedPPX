package com.z.service;

import com.z.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User userLogin(String username,String password);

    User getUserById(int userId);

    float retrieveUserBalance(int userId);

    void setUserImage(int userId,String url);

    String getUserImage(int userId);

    int editUserInformation(User user);

    int changeUserBalance(int userId,double newBalance);
}
