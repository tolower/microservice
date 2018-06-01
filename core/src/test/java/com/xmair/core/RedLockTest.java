package com.xmair.core;


import com.xmair.core.entity.framedb.TbEmpData;
import com.xmair.core.redlock.RedisRedLock;
import com.xmair.core.util.SpringBeanTools;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.RedissonRedLock;
import org.redisson.api.NodeType;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.protocol.decoder.SlotsDecoder;
import org.redisson.connection.CRC16;
import org.redisson.connection.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Service
public class RedLockTest {

    @Autowired
    RedissonClient client;

    //模拟互斥的库存资源

    private  static int productUnlockCount=10000;
    //模拟互斥的库存资源
    private  static int productLockCount=10000;
    /*测试object类*/

    @Test
    public  void ReduceProductCountWithLock(){

        /*todo 待优化 改成注解模式
        * */
        RLock lock1 = client.getLock("lock1");
        RLock lock2 = client.getLock("lock2");
        RLock lock3 = client.getLock("lock3");

        System.out.println(CRC16.crc16("lock1".getBytes())%16384);
        System.out.println(CRC16.crc16("lock2".getBytes())%16384);
        System.out.println(CRC16.crc16("lock3".getBytes())%16384);
        RedissonRedLock lock = new RedissonRedLock(lock1, lock2, lock3);

        try {

            boolean res = lock.tryLock(2, 10, TimeUnit.SECONDS);
            if(res==true){
                productLockCount-=1;
                System.out.println(productLockCount);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    @RedisRedLock
    public  void  AnnotationLock(){
        productLockCount-=1;
        System.out.println(productLockCount);
    }
    @Test
    public  void  TestAnnotationLock(){
        /*模拟代理方式调用加了分布式锁的方法。注意：不能直接在类内部互相调用，要避免*/
        SpringBeanTools.getBean(this.getClass()).AnnotationLock();
    }
    @Test
    public  void  testClusterInfo(){
        //CRC16.crc16()
        client.getClusterNodesGroup().getNodes(NodeType.MASTER).forEach(
                (node)-> System.out.println(node.info()));

    }
    public  void ReduceProductCount(){


        try {
            Thread.sleep(10);
        }catch (Exception e){

        }

        productUnlockCount-=1;
        System.out.println(productUnlockCount);

    }

    @Test
    public  void testUnLock() throws  Exception{
        for(int i=0; i<1000; i++){
            Thread thread=new Thread(this::ReduceProductCount);
            thread.start();
        }
        Thread.sleep(2000);

        System.out.println("最终："+productUnlockCount);

        Assert.assertNotEquals(9000,productUnlockCount);

    }
    @Test
    public  void testLock() throws  Exception{
        for(int i=0; i<1000; i++){
            Thread thread=new Thread(this::ReduceProductCountWithLock);
            thread.start();
        }
        Thread.sleep(20000);
        System.out.println("最终："+productLockCount);
        Assert.assertEquals(9000,productLockCount);

    }

}
