package com.z.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;


public class JsonResponseData {
    private static Gson gson=new GsonBuilder().create();

    public JsonResponseData() {
    }

    public JsonResponseData(Boolean ret, String msg, int code, String message, Object data) {
        this.ret = ret;
        this.msg = msg;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //是否成功
    private Boolean ret = false;

    //返回信息
    private String msg = null;

    //返回状态
    private int code = -100;

    //返回状态对应消息
    private String message = null;

    //返回数据
    private Object data = null;

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
