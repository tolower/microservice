package com.xmair.core.redlock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.connection.CRC16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Aspect
@Component
public class RedisRedLockAspect {

    @Autowired
    RedissonClient client;

    @Pointcut("@annotation(redisRedLock)")
    public void cut(RedisRedLock redisRedLock) {
    }

    @Around("cut(redisRedLock)")
    public Object  Redlock(ProceedingJoinPoint pjp,RedisRedLock redisRedLock){
        Object result = null;
        String prefix=pjp.getSignature().toShortString();
        RLock lock1 = client.getLock(prefix.concat("{lock1}"));
        RLock lock2 = client.getLock(prefix.concat("{lock2}"));
        RLock lock3 = client.getLock(prefix.concat("{lock3}"));

        RedissonRedLock lock = new RedissonRedLock(lock1, lock2, lock3);

        try {

            boolean res = lock.tryLock(redisRedLock.waitTime(), redisRedLock.leaseTime(), TimeUnit.MILLISECONDS);
            if(res==true){
               result=  pjp.proceed();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return  result;
    }
}
