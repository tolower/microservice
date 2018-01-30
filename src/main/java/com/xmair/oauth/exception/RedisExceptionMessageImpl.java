package com.xmair.oauth.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/*
* 根据错误代码从redis中获取错误信息
* */
@Component
public class RedisExceptionMessageImpl implements  ILogicExceptionMessage {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getMessage(String errCode) {

        String message=stringRedisTemplate.opsForValue().get(errCode);
        if(message==null){
            return  "系统未知异常";
        }
        return  message;
    }
}
