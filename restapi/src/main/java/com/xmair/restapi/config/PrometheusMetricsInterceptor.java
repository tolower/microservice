package com.xmair.restapi.config;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrometheusMetricsInterceptor extends HandlerInterceptorAdapter {

    //http总请求数
    static  Counter requestCounter = Counter.build()
            .name("http_requests_total").labelNames("path", "method", "code")
            .help("Total requests.").register();

    //当前特定http请求量
    static  Gauge inprogressRequests = Gauge.build()
            .name("http_inprogress_requests").labelNames("path", "method", "code")
            .help("Inprogress requests.").register();

    //客户端定义的数据分布统计
    static  Summary requestLatency = Summary.build()
            .name("http_requests_latency_seconds_summary")
            .quantile(0.5, 0.05)
            .quantile(0.9, 0.01)
            .labelNames("path", "method", "code")
            .help("Request latency in seconds.").register();


    //保证线程安全，使用threadLocal
    private static NamedThreadLocal<Summary.Timer> threadLocal=new NamedThreadLocal<Summary.Timer>("timer");


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        int status = response.getStatus();
        // 计数器+1
        inprogressRequests.labels(requestURI, method, String.valueOf(status)).inc();
        threadLocal.set(requestLatency.labels(requestURI, method, String.valueOf(status)).startTimer());

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        int status = response.getStatus();
        //inprogress 代表当前http请求量
        inprogressRequests.labels(requestURI, method, String.valueOf(status)).dec();
        requestCounter.labels(requestURI, method, String.valueOf(status)).inc();
        threadLocal.get().observeDuration();
        super.afterCompletion(request, response, handler, ex);
    }
}
