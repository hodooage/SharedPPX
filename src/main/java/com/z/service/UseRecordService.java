package com.z.service;

import com.z.pojo.UseRecord;

public interface UseRecordService {
    UseRecord getUseRecordById(int useRecordId);

    int insertNewUseRecord(UseRecord useRecord);

    int updateUseRecord(UseRecord useRecord);
}
