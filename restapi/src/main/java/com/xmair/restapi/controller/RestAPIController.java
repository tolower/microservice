package com.xmair.restapi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.entity.framedb.TbEmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.util.PageBean;
import com.xmair.core.util.ProtobufUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/restapi")
public class RestAPIController {
    @Autowired
    private EmpDataMapper empDataMapper;

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private RestTemplate restTemplate;

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
