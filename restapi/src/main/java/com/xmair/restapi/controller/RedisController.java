package com.xmair.restapi.controller;

import com.github.pagehelper.PageHelper;
import com.xmair.core.entity.User;
import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.redlock.RedisRedLock;
import com.xmair.restapi.apiversion.ApiVersion;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private EmpDataMapper empDataMapper;
    @Autowired
    private RedissonClient redissonClient;


    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    @ResponseBody
    public String test1(){


        RMap<String ,String> map=redissonClient.getMap("hash2");
        map.put("name","wuzuquan");
        map.put("pcode","06645");
        return map.get("pcode");
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "test str";
    }
    //模拟互斥的库存资源
    private  static int productLockCount=10000;
    @RedisRedLock
    @RequestMapping(value = "/testlock",method = RequestMethod.GET)
    public  void  AnnotationLock(){
        productLockCount-=1;
        System.out.println(productLockCount);
    }
}
