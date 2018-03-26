package com.z.service.serviceImpl;

import com.z.dao.mapper.XiaMapper;
import com.z.pojo.Xia;
import com.z.service.XiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiaServiceImpl  implements XiaService{
    @Autowired
    XiaMapper xiaMapper;

    @Override
    public int insert(Xia xia) {
        return xiaMapper.insertSelective(xia);
    }

    @Override
    public List<Xia> getNearByEnableXia(double minLng, double maxLng, double minLat, double maxLat) {
        return xiaMapper.getNearByEnableXia(minLng,maxLng,minLat,maxLat);
    }

    @Override
    public Xia getXiaById(int xiaId) {
        return xiaMapper.selectByPrimaryKey(xiaId);
    }

    @Override
    public int startXiaById(int xiaId) {
        return xiaMapper.startXiaById(xiaId);
    }

    @Override
    public int stopXiaById(int xiaId) {
        return xiaMapper.stopXiaById(xiaId);
    }


}
