package com.xmair.oauth.mapper.test2;

import java.util.List;

import com.xmair.oauth.entity.User;
import org.apache.ibatis.annotations.*;

public interface User2Mapper {


    @Select("SELECT * FROM user")

    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}