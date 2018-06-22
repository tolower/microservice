package com.xmair.restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmair.core.entity.framedb.TbEmpData;
import com.xmair.core.util.ResultBean;
import com.xmair.core.exception.ErrorMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestapiApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {

		mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
	}
	@Qualifier("signleTemplate")
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private  ObjectMapper objectMapper;

	@Test
	public  void testResultBean()  throws Exception {
		String uri = "/v1/tbempdata/get?id=06645";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);

		//ResultBean<TbEmpData> response = JsonUtil.json2GenericBean(content, new TypeReference<ResultBean<TbEmpData>>(){});
		ResultBean<TbEmpData> response=objectMapper.readValue(content, new TypeReference<ResultBean<TbEmpData>>(){});
		Assert.assertEquals(response.getData().getMfId(),"06645");


	}

	@Test
	public  void testRestTemplate()  throws Exception {
		String url = "http://11.4.74.51:567/v1/tbempdata/get?id=06645";
		ParameterizedTypeReference<ResultBean<TbEmpData>> typeRef = new ParameterizedTypeReference<ResultBean<TbEmpData>>() {};
		//  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		params.add("id", "06645");
		HttpHeaders headers = new HttpHeaders();
//  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<ResultBean<TbEmpData>> responseEntity = restTemplate.exchange(
				url, HttpMethod.GET,null , typeRef);
		ResultBean<TbEmpData> myModelClasses = responseEntity.getBody();

		//restTemplate.setMessageConverters();
		Assert.assertEquals(myModelClasses.getData().getMfId(),"06645");


	}


	@Test
	public  void testResponseEntity()  throws Exception {
		String url = "http://localhost:8080/v1/tbempdata/user?id=06645";

		ResponseEntity<String> responseEntity=null;
		try{
			responseEntity=restTemplate.getForEntity(url,String.class);
		}catch (Exception e){
			System.out.println(e.getStackTrace());
			return;
		}
		if(responseEntity.getStatusCode()==HttpStatus.OK){
			TbEmpData emp=objectMapper.readValue(responseEntity.getBody(),TbEmpData.class);

			System.out.println(emp.getMfId());
		}
		else {
			ErrorMessage errorMessage=objectMapper.readValue(responseEntity.getBody(),ErrorMessage.class);
		}



	}
}
