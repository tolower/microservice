package com.xmair.restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmair.core.entity.framedb.A1001;
import com.xmair.core.entity.framedb.TbEmpData;
import com.xmair.core.util.ResultBean;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

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
	public  void testSimpleService()  throws Exception {
		String url = "http://localhost:8080/v1/tbempdata/get?id=06645";
		ParameterizedTypeReference<ResultBean<TbEmpData>> typeRef = new ParameterizedTypeReference<ResultBean<TbEmpData>>() {};

		ResponseEntity<ResultBean<TbEmpData>> responseEntity = restTemplate.exchange(
				url, HttpMethod.GET,null , typeRef);
		ResultBean<TbEmpData> myModelClasses = responseEntity.getBody();

		Assert.assertEquals(myModelClasses.getData().getMfId(),"06645");

	}


	@Test
	public  void testListService()  throws Exception {
		String url = "http://localhost:8080/v1/organ/getlist?organCode=10.230";
		ParameterizedTypeReference<ResultBean<List<A1001>>> typeRef = new ParameterizedTypeReference<ResultBean<List<A1001>>>() {};

		ResponseEntity<ResultBean<List<A1001>>> responseEntity = restTemplate.exchange(
				url, HttpMethod.GET,null , typeRef);
		ResultBean<List<A1001>> myModelClasses = responseEntity.getBody();

		Assert.assertEquals(myModelClasses.getData().get(0).getOrganCode(),"10.230");

	}
}
