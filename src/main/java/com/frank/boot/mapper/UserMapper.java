package com.frank.boot.mapper;

import com.frank.boot.entities.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into user(name,age) values(#{name},#{age});")
    void insert(User user);

    @Select("select id,name,age from user;")
    List<User> selectAll();

    @Select("select id,name,age from user where id=#{id};")
    User selectById(Integer id);

    @Update("update user set name=#{name} ,age=#{age} where id=#{id}")
    void update(User user);

    @Delete("delete from user where id = #{value}")
    void deleteById(Integer id);
}
