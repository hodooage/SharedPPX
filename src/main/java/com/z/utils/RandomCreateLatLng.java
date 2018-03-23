package com.z.utils;

import com.z.dao.mapper.XiaMapper;
import com.z.pojo.Xia;
import com.z.service.XiaService;
import com.z.service.serviceImpl.XiaServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCreateLatLng {
    //根据经纬度用随机数来创造1000M之内的假数据
    public static List<Xia> createLatLng(double lng, double lat){
        //经度（东西方向）1M实际度：360°/31544206M=1.141255544679108e-5=0.00001141 longitude
        //纬度（南北方向）1M实际度：360°/40030173M=8.993216192195822e-6=0.00000899  latitude
        //经度（东西方向）1000M实际度：0.00001141°* 100=0.01141°
        //纬度（南北方向）1000M实际度：0.00000899°* 100=0.00899°

        List<Xia> xiaList=new ArrayList<Xia>();
        //经度最大最小值
        double maxX=lng+0.01141/2;
        double minX=lng-0.01141/2;

        //纬度最大最小值
        double maxY=lat+0.00899/2;
        double minY=lat-0.00899/2;

        for (int i=0;i<50;i++){
            double newLng=RandomUtils.nextDouble(minX,maxX);
            double newLat=RandomUtils.nextDouble(minY,maxY);
            Xia xia=new Xia();
            xia.setId(7451000+i);
            xia.setLatitude(newLat);
            xia.setLongitude(newLng);
            xia.setPrice(54f);
            xia.setType(0);
            xia.setState(0);
            System.out.println(newLng+","+newLat);
            xiaList.add(xia);
        }
        return xiaList;
    }

}
