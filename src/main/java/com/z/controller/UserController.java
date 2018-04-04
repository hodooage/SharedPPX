package com.z.controller;

import com.z.pojo.User;
import com.z.service.UserService;
import com.z.utils.JsonResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/client",produces = "text/plain;charset=utf-8")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUserById")
    @ResponseBody
    public String getUserByID(int userId){
        System.out.println("查询ID为"+userId+"的信息");
        return new JsonResponseData(true,"retrieve success",1,"查询成功",userService.getUserById(userId)).toString();
    }

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
    public String editUserInformation(@RequestBody User user){
        System.out.println("接收到用户"+user.getId()+"修改个人信息的请求");
//        user.setId(user.getUid());
        System.out.println(user.toString());
        return new JsonResponseData(true,"edit success",1,"修改成功",userService.editUserInformation(user)).toString();
    }

    @RequestMapping("/reduceUserBalance")
    @ResponseBody
    public String reduceUserBalance(int userId,double totalMoney){
        System.out.println("接收到扣钱请求");
        double nowBalance=userService.retrieveUserBalance(userId);
        double newBalance=nowBalance-totalMoney;
        if (newBalance>=0){
            return new JsonResponseData(true,"reduce success",1,"扣款成功",userService.changeUserBalance(userId,newBalance)).toString();
        }
        return new JsonResponseData(false,"reduce fail",1,"扣款失败","余额不足,请充值后再结束订单,当前余额"+nowBalance+",需要"+totalMoney).toString();
    }

    @RequestMapping("/addUserBalance")
    @ResponseBody
    public String addUserBalance(int userId,double totalMoney){
        System.out.println("接收到充钱请求");
        double nowBalance=userService.retrieveUserBalance(userId);
        double newBalance=nowBalance+totalMoney;
        return new JsonResponseData(true,"add success",1,"充值成功",userService.changeUserBalance(userId,newBalance)).toString();
    }
}
