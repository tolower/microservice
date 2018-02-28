package com.xmair.webapp.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Http2TestController {

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/http2")
    public  String TestHttp2(){
        long startTime=System.currentTimeMillis();//记录开始时间

        String url="http://localhost:8080/v1/tbempdata/get?pcode=06645";
        try {

            for (int i = 0; i <1 ; i++) {
                Request request=new Request.Builder().url(url).build();
                Response response =okHttpClient.newCall(request).execute();
                response.close();
/*
              String result=  restTemplate.getForObject(url,String.class);
               // System.out.println(result);*/
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        long endTime=System.currentTimeMillis();//记录结束时间

        long excTime=endTime-startTime;
        System.out.println("http耗时："+excTime);
        return  "5000次调用 http耗时"+excTime+"毫秒";
    }
}
