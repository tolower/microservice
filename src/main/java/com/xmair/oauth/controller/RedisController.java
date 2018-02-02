package com.xmair.oauth.controller;

import com.xmair.oauth.entity.EmpInfo;
import com.xmair.oauth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public User test(){

        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));


        User user=new User();
        user.setName("ssss");
        user.setAge(122);
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("wuzuquan", user);
        User s= operations.get("wuzuquan");
        return  s;
    }
}
