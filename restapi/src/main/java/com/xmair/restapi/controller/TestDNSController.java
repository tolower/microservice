package com.xmair.restapi.controller;

import com.xmair.core.entity.framedb.TbEmpData;
import com.xmair.core.exception.BusinessException;
import com.xmair.core.exception.MsgFactory;
import okhttp3.OkHttpClient;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/test")
public class TestDNSController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    RedissonClient client;

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    public String sync() throws InterruptedException {
        Thread.sleep(1000);
        return "sync";
    }



    @Autowired
    private Executor executorService;
    @RequestMapping(value = "/testasync",method = RequestMethod.GET)
    public DeferredResult<String> test11(){
        DeferredResult<String> deferredResult = new DeferredResult<>();
        executorService.execute(() -> {
            try {
                Thread.sleep(20);
                deferredResult.setResult("休眠20毫秒");
            } catch (Exception e) {
                deferredResult.setErrorResult(e);
            }

        });
        return deferredResult;
    }

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
     //   System.out.println(messageSource);
        /**
         * 模拟用户不存在
         * 抛出业务逻辑异常
         */
        if (true) {
            throw new BusinessException(MsgFactory.BusinessErr.couponAcceptPlatformErr);
        }
        return "ttttttttttttttt";
    }



    @RequestMapping(value = "/testQPS",method = RequestMethod.GET)
    public String index1() throws BusinessException {

        try{
            Thread.sleep(20);
        }catch (Exception e){

        }

        return "休眠20毫秒";
    }
    @RequestMapping(value = "/testinsurance",method = RequestMethod.GET)
    public String index2() throws BusinessException {


        try{
            Thread.sleep(20);
        }catch (Exception e){

        }

        logger.info("调用了保险服务");
        return "ttttttttttttttt";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public TbEmpData getUser(String id) {
        long startTime = System.currentTimeMillis();//记录开始时间
        String key = "com.xmair.restapi.controller.TbEmpDataControllergetUser06645";
        RMap<String, TbEmpData> map = client.getMap("user");

        TbEmpData item = map.get(key);
        long endTime=System.currentTimeMillis();//记录结束时间

        long excTime=endTime-startTime;

        //tracer.addTag("redis-time",String.valueOf(excTime));

        return item;
    }
    @RequestMapping(value = "/okhttp",method = RequestMethod.GET)
    public String TestOKhttp() {
       // KafkaSender
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
