package com.xmair.grpcclient;

import com.xmair.grpc.examples.GreeterGrpc;
import com.xmair.grpc.examples.HelloReply;
import com.xmair.grpc.examples.HelloRequest;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;

public class GrpcJobThread extends Thread {

    private  Channel serverChannel;

    private String name;
    public GrpcJobThread(Channel channel) {
        this.serverChannel=channel;
    }
    public void run() {
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(serverChannel);
        long startTime=System.currentTimeMillis();//记录开始时间
        for (int i = 0; i <5000 ; i++) {
            HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName("ddd").build());
            //System.out.println( response.getMessage());
        }
        long endTime=System.currentTimeMillis();//记录结束时间

        float excTime=endTime-startTime;
        System.out.println("grpc耗时："+excTime);

    }
}
