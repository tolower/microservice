package com.xmair.core;

import com.xmair.core.entity.framedb.TbEmpData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        RKeys keys= client.getKeys();
        Iterable<String> allKeys=keys.getKeys();
        keys.getKeysByPattern("keys*");
        System.out.println(keys.count());

        System.out.println(client.getConfig().isClusterConfig());
        //注意事项：get set 操作时，需要人工保证分配到同一个slot上，否则异常，用{}标签来指定要参与hash计算的字符串
        client.getBuckets().get("key1{1}test1","key{1}:test2");

        client.getBucket("11").set("11");

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
   测试 hash 类型的get set
   * */
    @Test
    public  void testHashRedis(){

        RMap<String ,String> map=client.getMap("hash2");
        map.put("name","wuzuquan");
        map.put("pcode","06645");
        System.out.println( map.get("pcode"));
    }
}
