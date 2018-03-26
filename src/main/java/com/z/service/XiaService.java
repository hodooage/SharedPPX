package com.z.service;

import com.z.pojo.Xia;

import java.util.List;

public interface XiaService {
    int insert(Xia xia);

    List<Xia> getNearByEnableXia(double minLng,double maxLng,double minLat,double maxLat);

    Xia getXiaById(int xiaId);

    int startXiaById(int xiaId);

    int stopXiaById(int xiaId);
}
