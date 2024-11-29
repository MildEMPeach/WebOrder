package org.mildempeach.service;

import org.mildempeach.entity.Record;
import org.mildempeach.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecordService {
    @Autowired
    RecordMapper recordMapper;

    public void InsertRecord(Record record) {
        recordMapper.insertRecord(record);
    }

    public List<Record> getRecordByBillId(long billId) {
        return recordMapper.selectRecordByBillId(billId);
    }

}
