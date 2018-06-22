package com.xmair.core.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class BusinessThreadPoolConfig {
    @Value("${threadpool.corepoolsize}")
    int corePoolSize;

    @Value("${threadpool.maxpoolsize}")
    int maxPoolSize;

    @Primary
    @Bean
    public ExecutorService customExecutorService() {
        return Executors.newFixedThreadPool(maxPoolSize, new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "biz-service-" + threadNumber.getAndIncrement());
            }
        });

    }

    @Bean
    public Lifecycle customExecutorServiceLifeCycle() {

        final ExecutorService executorService = customExecutorService();
        return new Lifecycle() {

            @Override
            public void start() {

            }

            @Override
            public void stop() {

                executorService.shutdown();
                boolean successfulTerminated = false;
                try {
                    successfulTerminated = executorService.awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!successfulTerminated) {
                    executorService.shutdownNow();
                }

            }

            @Override
            public boolean isRunning() {
                return !executorService.isTerminated();
            }

        };
    }
}
