package com.xmair.core;

import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.util.SpringBeanTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {


	@Test
    public 	void testBeanTool(){

	   	EmpDataMapper mapper=SpringBeanTools.getBean(EmpDataMapper.class);
		EmpData empData=mapper.selectByPrimaryKey("06645");
		System.out.println(empData.getCnName());
	}

	@Test
	public void contextLoads() {

		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, Comparator.comparing(String ::toString).reversed());
		Collections.sort(names,(a,b)->a.compareTo(b));
		for (String name : names) {
			System.out.println(name);
		}


		// 使用 lambda 表达式以及函数操作(functional operation)
		names.forEach((player) -> System.out.print(player + "; "));

// 在 Java 8 中使用双冒号操作符(double colon operator)
		names.forEach(System.out::println);
	}
}
