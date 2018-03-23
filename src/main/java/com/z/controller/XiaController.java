package com.z.controller;

import com.z.pojo.Xia;
import com.z.service.XiaService;
import com.z.utils.RandomCreateLatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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
}
