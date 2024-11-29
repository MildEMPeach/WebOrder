package org.mildempeach.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mildempeach.entity.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(@Param("id") int id);

    @Select("SELECT * FROM users WHERE name= #{name}")
    User getUserByName(@Param("name") String name);

    @Select("SELECT * FROM users WHERE name = #{name} AND password = #{passwd}")
    User getUserByNameAndPassword(@Param("name") String name, @Param("passwd") String passwd);

    @Insert("INSERT INTO users (name, password) VALUES (#{name}, #{passwd})")
    void insertUser(@Param("name") String name, @Param("passwd") String passwd);
}
