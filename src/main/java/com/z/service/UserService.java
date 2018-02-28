package com.z.service;

import com.z.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User userLogin(String username,String password);

    User getUserByID(int userId);

    float retrieveUserBalance(int userId);
}
