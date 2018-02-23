package com.xmair.grpc.service;

import com.xmair.grpc.examples.GreeterGrpc;
import com.xmair.grpc.examples.HelloReply;
import com.xmair.grpc.examples.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(GreeterGrpc.class)
public class GrpcServer extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello =============> " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
