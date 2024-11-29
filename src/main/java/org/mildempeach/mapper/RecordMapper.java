package org.mildempeach.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mildempeach.entity.Record;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert("INSERT INTO records (billid, userid, instrumentid, instrumentname, number)" +
            "VALUES (#{record.billid}, #{record.customerid}, #{record.instrumentid}, #{record.instrumentname}, #{record.number})")
    void insertRecord(@Param("record") Record record);

    @Select("SELECT * FROM records WHERE billid=#{billid}")
    List<Record> selectRecordByBillId(@Param("billid") long billid);
}
