package com.xmair.webapp.controller;

import com.xmair.core.util.HttpUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class Http2TestController {

    public static OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        return builder.build();
    }

    @RequestMapping(value = "/http2")
    public  String TestHttp2(){
        long startTime=System.currentTimeMillis();//记录开始时间

        OkHttpClient okHttpClient=okHttpClient();
        try {

            for (int i = 0; i <5000 ; i++) {
                Request request=new Request.Builder().
                        url("http://localhost:8080/v2/user/getuser?pcode=06645").
                        build();
                Response response =okHttpClient.newCall(request).execute();
                //	System.out.println("Date: " + response.header("Connection"));
                	response.close();
                //	System.out.println(response.body().string());
              //  HttpUtil.doGet("http://localhost:8080/v2/user/getuser?pcode=06645");
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
