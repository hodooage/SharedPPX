package com.z.service.serviceImpl;

import com.z.dao.mapper.XiaMapper;
import com.z.pojo.Xia;
import com.z.service.XiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XiaServiceImpl  implements XiaService{
   //@Autowired
    XiaMapper xiaMapper=new XiaMapper() {
       @Override
       public int deleteByPrimaryKey(Integer id) {
           return 0;
       }

       @Override
       public int insert(Xia record) {
           return 0;
       }

       @Override
       public int insertSelective(Xia record) {
           return 0;
       }

       @Override
       public Xia selectByPrimaryKey(Integer id) {
           return null;
       }

       @Override
       public int updateByPrimaryKeySelective(Xia record) {
           return 0;
       }

       @Override
       public int updateByPrimaryKey(Xia record) {
           return 0;
       }
   };

    @Override
    public int insert(Xia xia) {
        return xiaMapper.insertSelective(xia);
    }
}
