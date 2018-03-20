package com.z.service.serviceImpl;

import com.z.dao.mapper.UserMapper;
import com.z.pojo.User;
import com.z.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;



    @Override
    public User userLogin(String username, String password) {
        System.out.println(userMapper);
        return userMapper.userLogin(username,password);
    }

    @Override
    public User getUserByID(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public float retrieveUserBalance(int userId) {
        return userMapper.retrieveUserBalance(userId);
    }

    @Override
    public void setUserImage(int userId, String url) {
        userMapper.setUserImage(userId,url);
    }

    @Override
    public String getUserImage(int userId) {
        return userMapper.getUserImage(userId);
    }

    @Override
    public int editUserInformation(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
