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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        thisUseRecord.setPrice(Double.valueOf(thisXia.getPrice()));
        //状态为0表示正在骑行
        thisUseRecord.setState(0);
        System.out.println("插入前主键ID为"+thisUseRecord.getId());
        useRecordService.insertNewUseRecord(thisUseRecord);
        System.out.println("插入后主键ID为"+thisUseRecord.getId());

        System.out.println(new JsonResponseData(true,"create useRecord Success",1,"创建订单成功",thisUseRecord).toString());

        return new JsonResponseData(true,"create useRecord Success",1,"创建订单成功",thisUseRecord).toString();
    }

    //骑行结束更新骑行记录
    @RequestMapping("/updateUseRecord")
    @ResponseBody
    public String updateUseRecord(int useRecordId,String stopSite,String duration, double totalMoney){
        UseRecord useRecord=useRecordService.getUseRecordById(useRecordId);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stopTime=sdf.format(new Date());

        useRecord.setStoptime(stopTime);
        useRecord.setStopsite(stopSite);
        useRecord.setDuration(duration);
        useRecord.setTotalmoney(totalMoney);
        useRecord.setState(1);

       if(useRecordService.updateUseRecord(useRecord)!=0){
           return new JsonResponseData(true,"update useRecord Success",1,"更新订单成功","success").toString();
       }
        return new JsonResponseData(true,"update useRecord fail",1,"更新订单失败","fail").toString();
    }

    @RequestMapping("/getSystemTime")
    @ResponseBody
    public String getSystemTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("获取到系统时间");
        return new JsonResponseData(true,"get System Time Success",1,"获取系统时间成功",sdf.format(new Date())).toString();
    }

    @RequestMapping("/checkRunningOrder")
    @ResponseBody
    public String checkRunningOrder(int userId){
        System.out.println("检查用户ID"+userId+"正在骑行的订单");
        UseRecord useRecord;
        if(useRecordService.checkRunningOrder(userId)!=null){
            useRecord=useRecordService.checkRunningOrder(userId);
            System.out.println("查到的订单详细信息为："+useRecord.toString());
            return new JsonResponseData(true,"retrieved an  running order ",1,"查询到一个正在骑行的订单",useRecord).toString();
        }
        return new JsonResponseData(false,"no running order ",1,"没有正在骑行的订单",null).toString();
    }

    //根据用户ID获取骑行记录
    @RequestMapping("/getUseRecordByUserId")
    @ResponseBody
    public String getUseRecordByUserId(int userId){
        System.out.println("查询用户"+userId+"的骑行记录");
        List<UseRecord> useRecordList=useRecordService.getUseRecordByUserId(userId);
        if(useRecordList!=null){
            return new JsonResponseData(true,"find some order ",1,"查到这些订单记录",useRecordList).toString();
        }
        return new JsonResponseData(false,"no  order ",0,"没有查询到订单记录",null).toString();
    }

}
