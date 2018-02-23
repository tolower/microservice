package com.xmair.grpcclient;

import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class GrpcClientApplicationTests {

	@GrpcClient("grpc-server")
	private  Channel serverChannel;

	@Test
	public void contextLoads() {

		Thread grpc=new GrpcJobThread(serverChannel);
		//grpc.start();
		grpc.run();

	}

}
