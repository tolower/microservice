package com.xmair.oauth.mapper.test1;

import com.xmair.oauth.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User1Mapper {


    @Select("SELECT * FROM user")

    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}