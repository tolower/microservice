package com.xmair.restapi;

import com.xmair.core.entity.framedb.TbEmpData;
import com.xmair.core.util.ResultBean;
import okhttp3.OkHttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {


    @Qualifier("signleTemplate")
    @Autowired
    private RestTemplate restTemplate;



    @Test
    public  void testRestTemplate()  throws Exception {
        String url = "http://11.4.74.47:888/v1/tbempdata/get";
        ParameterizedTypeReference<ResultBean<TbEmpData>> typeRef = new ParameterizedTypeReference<ResultBean<TbEmpData>>() {};
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("id", "06645");
        HttpHeaders headers = new HttpHeaders();
//  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<ResultBean<TbEmpData>> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET,requestEntity , typeRef);
        ResultBean<TbEmpData> myModelClasses = responseEntity.getBody();


        Assert.assertEquals(myModelClasses.getData().getMfId(),"06645");


    }
}
