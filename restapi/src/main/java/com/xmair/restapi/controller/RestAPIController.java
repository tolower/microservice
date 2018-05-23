package com.xmair.restapi.controller;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.Check;
import com.ecwid.consul.v1.health.model.HealthService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.entity.framedb.TbEmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.util.PageBean;
import com.xmair.core.util.ProtobufUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/restapi")
public class RestAPIController {
    @Autowired
    private EmpDataMapper empDataMapper;

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/zipkintest")
    public  String testRibbon(){

        return restTemplate.getForObject("http://booking-service/v1/tbempdata/get?id=06645",String.class);
    }
    @RequestMapping(value = "/ordertest")
    public  String testTrace(){

        return restTemplate.getForObject("http://product-service/restapi/zipkintest",String.class);
    }
    @RequestMapping(value = "/order")
    public  String testTrace1(){

        return restTemplate.getForObject("http://order-service/redis/test",String.class);
    }
    @Autowired
    private ConsulClient consulClient;
   // DynamicServerListLoadBalancer
    @RequestMapping(value = "/consulregisterrefresh")
    public String consulrefresh(String  id){
      /*  List<HealthService> response = consulClient.getHealthServices(id, false, null).getValue();
        for(HealthService service : response) {
            // 创建一个用来剔除无效实例的ConsulClient，连接到无效实例注册的agent
            ConsulClient clearClient = new ConsulClient(service.getNode().getAddress(), 8500);
            service.getChecks().forEach(check -> {
                if(check.getStatus() != Check.CheckStatus.PASSING) {
                    //logger.info("unregister : {}", check.getServiceId());
                    clearClient.agentServiceDeregister(check.getServiceId());
                }
            });
        }*/

        List<HealthService> response = consulClient.getHealthServices(id, false, null).getValue();
        for(HealthService service : response) {
            service.getChecks().forEach(check -> {
                if(!check.getStatus().name().equals(Check.CheckStatus.PASSING.name())) {
                    //logger.info("unregister : {}", check.getServiceId());
                    consulClient.agentServiceDeregister(check.getServiceId());
                }
            });
        }

        return null;

    }

    @RequestMapping(value = "/index")
    public String index(int number){
        System.out.println(20 / number);
        return "get index page successfully.";
    }
    @RequestMapping(value = "/test")
    public  void  test() throws IOException{
        String url="http://localhost:8080/v1/tbempdata/get?id=06645";
        Request request=new Request.Builder().url(url).build();
        Response response =okHttpClient.newCall(request).execute();
        byte[] result=response.body().bytes();


        TbEmpData item= ProtobufUtil.deserialize(result,TbEmpData.class);

        response.close();

        restTemplate.getForObject(url,String.class);
    }

    @RequestMapping("/getOracleUser")
    public PageBean getOUser() {
        PageBean result=new PageBean();
        PageHelper.startPage(1, 20);
        List<EmpData> list = empDataMapper.selectAll();

        for (EmpData country : list) {
            System.out.println("Country Name: " + country.getCnName());
        }
        result.setData(list);
        result.setPageNum(1);
        result.setPageSize(20);
        result.setTotal(((Page)list).getTotal());
        return result;
    }
}
