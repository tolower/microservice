package com.xmair.auth.authserver.service;


import com.xmair.auth.authserver.Entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {


    private final static Map<String, String> map = new HashMap<String,String>();


    //静态初始化块
    static {
        map.put("user1","password1");
        map.put("user2","password2");
    }

    public static void  set(String key,String value,int expire){
        map.put(key,value);
    }

    public static User findByUsername(String username){

        User user=new User();
        user.setName(username);
        user.setPassword("111111111");
        return  user;
    }

    public static boolean hasKey(String key){
        return map.containsKey(key);
    }

    public static   long getExpire(String key){

        return  10000;
    }

    public static void  del(String key){
        map.remove(key);
    }
}
