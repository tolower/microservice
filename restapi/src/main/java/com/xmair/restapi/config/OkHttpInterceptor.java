package com.xmair.restapi.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OkHttpInterceptor implements Interceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());
        int i=0;
    @Override
    public Response intercept(Chain chain) throws IOException {
        // get token

        Request originalRequest = chain.request();
        i+=1;

        logger.info(String.format("sending request %s ,%d",originalRequest.url(),i));
        // get new request, add request header
        Request updateRequest = originalRequest.newBuilder()
                .header("token", "test")
                //.header("Accept","application/x-protobuf")
                .build();
        return chain.proceed(updateRequest);
    }
}
