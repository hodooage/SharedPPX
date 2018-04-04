package com.z.service.serviceImpl;

import com.z.dao.mapper.UseRecordMapper;
import com.z.pojo.UseRecord;
import com.z.service.UseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseRecordServiceImpl implements UseRecordService{
    @Autowired
    UseRecordMapper useRecordMapper;

    @Override
    public UseRecord getUseRecordById(int useRecordId) {
        return useRecordMapper.selectByPrimaryKey(useRecordId);
    }

    @Override
    public int insertNewUseRecord(UseRecord useRecord) {
        return useRecordMapper.insertSelective(useRecord);
    }

    @Override
    public int updateUseRecord(UseRecord useRecord) {
        return useRecordMapper.updateByPrimaryKeySelective(useRecord);
    }
}
