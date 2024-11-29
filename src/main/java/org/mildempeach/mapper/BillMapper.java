package org.mildempeach.mapper;

import org.apache.ibatis.annotations.*;
import org.mildempeach.entity.Bill;

import java.util.List;

@Mapper
public interface BillMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO bills (userid, amount, weight) VALUES (#{bill.customerid}, #{bill.amount}, #{bill.weight})")
    void insertBill(@Param("bill") Bill bill);

    @Select("SELECT * FROM bills WHERE userid=#{customerid}")
    List<Bill> selectBillsByCustomerId(@Param("customerid") int customerid);
}
