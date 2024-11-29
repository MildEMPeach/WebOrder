package org.mildempeach.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mildempeach.entity.Review;

import java.util.List;

@Mapper
public interface ReviewMapper {

    @Insert("INSERT INTO reviews (instrumentid, userid, comment) " +
            "VALUES (#{review.instrumentid}, #{review.userid}, #{review.comment})")
    void insertReview(@Param("review") Review review);

    @Select("SELECT * FROM reviews WHERE instrumentid=#{instrumentid} AND userid=#{userid}")
    Review getReviewById(@Param("instrumentid") long instrumentid, @Param("userid") long userid);

    @Select("SELECT * FROM reviews WHERE instrumentid=#{instrumentid}")
    List<Review> getReviewByInstrumentid(@Param("instrumentid") long instrumentid);
}
