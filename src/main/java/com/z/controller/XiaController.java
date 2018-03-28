package com.z.controller;

import com.z.pojo.Xia;
import com.z.service.XiaService;
import com.z.utils.JsonResponseData;
import com.z.utils.RandomCreateLatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/client")
public class XiaController {
    @Autowired
    XiaService xiaService;

    @RequestMapping("/randomCreateXia")
    public void randomCreateXia(){
        List<Xia> xiaList=RandomCreateLatLng.createLatLng(109.943427,27.530085);
        for (int i=0;i<xiaList.size();i++ ) {
            System.out.println(xiaList.get(i).toString());
            xiaService.insert(xiaList.get(i));
        }
        System.out.println("插入50条数据成功");
    }

    @RequestMapping("/getNearByEnableXia")
    @ResponseBody
    public String getNearByEnableXia(double lng,double lat){
        System.out.println("查询"+lng+","+lat+"附近可用的车");
        //经度最大最小值
        double maxLng=lng+0.01141/2;
        double minLng=lng-0.01141/2;
        //纬度最大最小值
        double maxLat=lat+0.00899/2;
        double minLat=lat-0.00899/2;
        List<Xia> xiaList= xiaService.getNearByEnableXia(minLng,maxLng,minLat,maxLat);

        return new JsonResponseData(true,"retrieve success",1,"查询成功",xiaList).toString();
    }

    @RequestMapping("/getXiaById")
    @ResponseBody
    public String getXiaById(int xiaId){
        Xia xia=xiaService.getXiaById(xiaId);
        return new JsonResponseData(true,"retrieve success",1,"查询成功",xia).toString();
    }

    @RequestMapping("/startXiaById")
    @ResponseBody
    public String startXiaById(int xiaId){
        if(xiaService.startXiaById(xiaId)!=0){
            return new JsonResponseData(true,"retrieve success",1,"修改成功","状态已修改为1").toString();
        }
        return new JsonResponseData(false,"retrieve fail",1,"修改失败","状态未更改").toString();
    }

    @RequestMapping("/stopXiaById")
    @ResponseBody
    public String stopXiaById(int xiaId){
        if(xiaService.stopXiaById(xiaId)!=0){
            return new JsonResponseData(true,"retrieve success",1,"修改成功","状态已修改为0").toString();
        }
        return new JsonResponseData(false,"retrieve fail",1,"修改失败","状态未更改").toString();
    }
}
