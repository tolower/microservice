package com.xmair.restapi.controller;

import com.xmair.core.exception.BusinessException;
import com.xmair.core.exception.ResultCodeEnum;
import com.xmair.restapi.apiversion.ApiVersion;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    public String index() throws BusinessException {
        /**
         * 模拟用户不存在
         * 抛出业务逻辑异常
         */
        if (true) {
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.toString(),"异常处理测试");
        }
        return "ttttttttttttttt";
    }

    @RequestMapping(value = "/okhttp",method = RequestMethod.GET)
    public String TestOKhttp() {

        long startTime = System.currentTimeMillis();//记录开始时间

        String url = "http://dnstest.microservice-test:8080/test/getip";
        StringBuffer stringBuffer = new StringBuffer();
        try {

            for (int i = 0; i < 100; i++) {
                Request request = new Request.Builder().url(url).build();
                Response response = okHttpClient.newCall(request).execute();
                stringBuffer.append(response.body().string());
                response.close();
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
