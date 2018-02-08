package com.xmair.core.util;


import java.util.HashMap;
import java.util.Map;

public class MemCacheUtil {
    private final static Map<String, Object> map = new HashMap<String,Object>();


    //静态初始化块
    static {
        map.put("appid1","appkey1");
        map.put("appid2","appkey2");
        map.put("appid3","appkey3");
    }

    public static void  set(String key,Object value){
        map.put(key,value);
    }

    public static void  remove(String key){
        map.remove(key);
    }
    public static String get(String key){
        Object o=map.get(key);
        if(o==null){
            return  null;
        }
        return  map.get(key).toString();
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