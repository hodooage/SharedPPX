package com.z.controller;

import com.z.pojo.User;
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
        System.out.println("查询了ID为"+userId+"的余额");
        return  new JsonResponseData(true,"retrieve success",1,"查询成功",userService.retrieveUserBalance(userId)).toString();
    }

    @RequestMapping(value = "/editUserInformation",method = RequestMethod.POST)
    @ResponseBody
    public String editUserInformation(User user){

        return new JsonResponseData(true,"edit success",1,"修改成功",userService.editUserInformation(user)).toString();
    }

}
