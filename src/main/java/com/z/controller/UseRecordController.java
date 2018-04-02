package com.z.controller;

import com.z.pojo.UseRecord;
import com.z.pojo.Xia;
import com.z.service.UseRecordService;
import com.z.service.XiaService;
import com.z.utils.JsonResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/client",produces = "text/plain;charset=utf-8")
public class UseRecordController {
    @Autowired
    UseRecordService useRecordService;

    @Autowired
    XiaService xiaService;

    //插入新的骑行记录并返回这条记录
    @RequestMapping("/insertNewUseRecord")
    @ResponseBody
    private String insertNewUseRecord(int userId,int xiaId){
        //首次创建骑行记录需要用户ID，虾ID,开始时间，开始地点（开始地点用虾的初始地点就可以）
        Xia thisXia=xiaService.getXiaById(xiaId);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime=sdf.format(new Date());

        UseRecord thisUseRecord=new UseRecord();
        thisUseRecord.setStartsite(thisXia.getLatitude()+","+thisXia.getLongitude());
        thisUseRecord.setStarttime(startTime);
        thisUseRecord.setuId(userId);
        thisUseRecord.setxId(xiaId);
        //状态为0表示正在骑行
        thisUseRecord.setState(0);
        System.out.println("插入前主键ID为"+thisUseRecord.getId());
        useRecordService.insertNewUseRecord(thisUseRecord);
        System.out.println("插入后主键ID为"+thisUseRecord.getId());

        return new JsonResponseData(true,"create useRecord Success",1,"创建订单成功",thisUseRecord).toString();
    }

    //骑行结束更新骑行记录
    @RequestMapping("/updateUseRecord")
    @ResponseBody
    public String updateUseRecord(int userId,String stopTime,String stopSite,double totalMoney){
        return null;
    }

}
