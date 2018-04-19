package com.z.service;

import com.z.pojo.UseRecord;

import java.util.List;

public interface UseRecordService {
    UseRecord getUseRecordById(int useRecordId);

    int insertNewUseRecord(UseRecord useRecord);

    int updateUseRecord(UseRecord useRecord);

    UseRecord checkRunningOrder(int userId);

    List<UseRecord> getUseRecordByUserId(int userId);
}
