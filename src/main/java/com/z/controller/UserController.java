package com.z.controller;

import com.z.service.UserService;
import com.z.utils.JsonResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/client",produces = "text/plain;charset=utf-8")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(String username,String password){
        System.out.println("收到登录请求");
        return new JsonResponseData(true,"login success",1,"登录成功",userService.userLogin(username,password)).toString();
    }

    @RequestMapping("/retrieveUserBalance")
    @ResponseBody
    public String retrieveUserBalance(int userId){
        return  new JsonResponseData(true,"retrieve success",1,"查询成功",userService.retrieveUserBalance(userId)).toString();
    }


}
