package com.xmair.restapi.controller;

import com.github.pagehelper.PageHelper;
import com.xmair.core.entity.User;
import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EmpDataMapper empDataMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public User test(){

        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));


        ValueOperations<String, List<EmpData>> operations1=redisTemplate.opsForValue();

        PageHelper.startPage(1, 20);
        List<EmpData> list = empDataMapper.selectAll();
        operations1.set("protolist", list);

        operations1.get("protolist").forEach((item) -> System.out.println(item.getCnName() + "; "));
        User user=new User();
        user.setName("ssss");
        user.setAge(122);
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("wuzuquan", user);
        User s= operations.get("wuzuquan");
        //HashOperations<String,String,User> hashOperations=redisTemplate.opsForHash();
        return  s;
    }
}
