package org.mildempeach.mapper;

import org.apache.ibatis.annotations.*;
import org.mildempeach.entity.Cart;

import java.util.List;

@Mapper
public interface CartMapper {
    @Insert("INSERT INTO carts(userid, instrumentid, instrumentname, number, price, weight) " +
            "VALUES (#{userid}, #{instrumentid}, #{instrumentname}, #{number}, #{price}, #{weight})")
    void insertCart(@Param("userid") long userid, @Param("instrumentid") long instrumentid,
                    @Param("instrumentname") String instrumentname, @Param("number") int number,
                    @Param("price") double price, @Param("weight") double weight);

    @Select("SELECT * FROM carts WHERE userid=#{userid}")
    List<Cart> getCartsByUserid(@Param("userid") long userid);

    @Delete("DELETE FROM carts WHERE userid=#{userid} AND instrumentid=#{instrumentid}")
    void deleteCartByUseridAndInstrumentId(@Param("userid") long userid, @Param("instrumentid") long instrumentid);

    @Delete("DELETE FROM carts WHERE userid=#{userid}")
    void deleteCartByUserid(@Param("userid") long userid);
}
