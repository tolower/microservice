package com.xmair.grpcclient;

import com.xmair.core.util.HttpUtil;

public class RestJobThread extends  Thread{
    private String name;
    public RestJobThread(String name) {
        this.name=name;
    }

    public void run() {
        long   startTime=System.currentTimeMillis();//记录开始时间
        for (int i = 0; i <5000 ; i++) {
            HttpUtil.doGet("http://localhost:8080/getuser");
        }
        long endTime=System.currentTimeMillis();//记录结束时间

        long excTime=endTime-startTime;
        System.out.println("http耗时："+excTime);

    }
}
