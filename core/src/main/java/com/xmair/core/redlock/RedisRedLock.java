package com.xmair.core.redlock;

import java.lang.annotation.*;

/**
redlock分布式锁
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisRedLock {



    /**
     * 轮询锁的时间超时时常, 单位: ms
     */
    int waitTime() default 2000;

    /**
     * redis-key失效时常, 单位: ms
     */
    int leaseTime() default 3000;

}