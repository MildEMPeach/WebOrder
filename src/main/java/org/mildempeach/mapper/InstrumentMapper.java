package org.mildempeach.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mildempeach.entity.Instrument;

import java.util.List;

@Mapper
public interface InstrumentMapper {
    @Select("SELECT * FROM instruments")
    List<Instrument> selectAllInstruments();

    @Select("SELECT * FROM instruments where id = #{id}")
    Instrument selectInstrumentById(@Param("id") int instrumentId);
}
