package com.xmair.core;

import com.xmair.core.entity.framedb.TbEmpData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.RedissonMap;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedissonClient client;


    /*
   测试 string 类型的get set
   * */
    @Test
    public  void testStringRedis(){



        System.out.println(client.getConfig().isClusterConfig());
        //注意事项：get set 操作时，需要人工保证分配到同一个slot上，否则异常，用{}标签来指定要参与hash计算的字符串
        client.getBuckets().get("key1{1}test1","key{1}:test2");  


        //设置了key：11 ，value：value11,20分钟有效期
        client.getBucket("11").set("value11",20, TimeUnit.MINUTES);
        TbEmpData item=new TbEmpData();
        item.setCnName("wuzquan");
        RBucket<TbEmpData> r= client.getBucket("123");
        r.set(item);
        System.out.println( r.get().getCnName());
        Object result= client.getBucket("11").get();
        System.out.println(result);
    }


    /*测试object类*/
    @Test
    public  void testObjectRedis(){

        TbEmpData item=new TbEmpData();
        item.setCnName("wuzquan");
        RBucket<TbEmpData> r= client.getBucket("123");
        r.set(item);
        System.out.println( r.get().getCnName());

    }
    /*
   推荐的做法：模拟批量set,先把kv扔到一个hashmap里，利用hmset批量保存。
   原因：分布式环境里对mset要求比较苛刻

   * */
    @Test
    public  void testBatch(){

        Map<String,String> hashmap=new HashMap<>();
        hashmap.put("test1","1111sssss");
        hashmap.put("test12","1112");
        hashmap.put("test11","1113");

        RMap<String ,String> map=client.getMap("pnr_test");
        map.expire(20,TimeUnit.MINUTES);
        map.putAll(hashmap);

        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getValue());
            System.out.println(entry.getKey());
        }
    }

    /*
测试 hash 类型的get set
* */
    @Test
    public  void testHash(){


        RMap<String ,String> map=client.getMap("au_testapp");

        System.out.println( map.get("/usertest/v1/tbempdata/userGET"));
    }
}
