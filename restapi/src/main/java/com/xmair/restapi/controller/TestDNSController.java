package com.xmair.restapi.controller;

import com.xmair.core.exception.Business500Exception;
import com.xmair.core.exception.BusinessExceptionEnum;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/test")
public class TestDNSController {


    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getip",method = RequestMethod.GET)
    public  String GetIP()
    {
        try {
            return  "本机ip："+  InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e){
            return  e.getMessage();
        }

    }

    @RequestMapping(value = "/testException",method = RequestMethod.GET)
    public String index() throws Business500Exception {
        /**
         * 模拟用户不存在
         * 抛出业务逻辑异常
         */
        if (true) {
            throw new Business500Exception(BusinessExceptionEnum.DBerror);
        }
        return "ttttttttttttttt";
    }

    @RequestMapping(value = "/okhttp",method = RequestMethod.GET)
    public String TestOKhttp() {

        long startTime = System.currentTimeMillis();//记录开始时间

        String url = "http://booking-service/test/getip";
        StringBuffer stringBuffer = new StringBuffer();
        try {

            for (int i = 0; i < 100; i++) {
                String result= restTemplate.getForObject(url,String.class);
                stringBuffer.append(result);

/*
              String result=  restTemplate.getForObject(url,String.class);
               // System.out.println(result);*/
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        long endTime=System.currentTimeMillis();//记录结束时间

        long excTime=endTime-startTime;
        System.out.println("http耗时："+excTime);
        return  stringBuffer.toString()+excTime;
    }
}
