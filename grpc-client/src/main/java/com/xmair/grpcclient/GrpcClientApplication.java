package com.xmair.grpcclient;

import com.xmair.core.util.HttpUtil;
import com.xmair.grpc.examples.GreeterGrpc;
import com.xmair.grpc.examples.HelloReply;
import com.xmair.grpc.examples.HelloRequest;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
public class GrpcClientApplication {

	@GrpcClient("grpc-server")
	private static Channel serverChannel;


	public static OkHttpClient okHttpClient() {
		return new OkHttpClient();
	}


    private  static 	OkHttpClient okHttpClient;
	public static void main(String[] args){
		SpringApplication.run(GrpcClientApplication.class, args);
		GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(serverChannel);
		long startTime=System.currentTimeMillis();//记录开始时间
		for (int i = 0; i <5000 ; i++) {
			HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName("ddd").build());
			//System.out.println( response.getMessage());
		}
		long endTime=System.currentTimeMillis();//记录结束时间

		float excTime=endTime-startTime;
		System.out.println("grpc耗时："+excTime);

		 startTime=System.currentTimeMillis();//记录开始时间


		try {

			OkHttpClient.Builder builder = new OkHttpClient.Builder();
			builder.connectTimeout(30, TimeUnit.SECONDS)
					.readTimeout(30, TimeUnit.SECONDS)
					.writeTimeout(30,TimeUnit.SECONDS)
					.retryOnConnectionFailure(true);
			okHttpClient= new OkHttpClient();
			String url="http://localhost:8080/getuser";
			for (int i = 0; i <5000 ; i++) {
				Request request=new Request.Builder().url(url).build();
				Response response =okHttpClient.newCall(request).execute();
				if(response.isSuccessful()) {
					//System.out.println(response.body().string());
					response.close();
				}
				//HttpUtil.doGet(url);
			}
		}
catch (Exception e){
	System.out.println(e.getMessage());
}
		 endTime=System.currentTimeMillis();//记录结束时间

		 excTime=endTime-startTime;
		System.out.println("okhttp耗时："+excTime);


	}
}
