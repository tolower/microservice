package com.xmair.core.configuration.kafka;

import ch.qos.logback.classic.spi.*;
import ch.qos.logback.core.CoreConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmair.core.configuration.zipkin.ZipkinProperties;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.SpringBeanTools;
import org.slf4j.MDC;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Stream;
public class MessageFormatter implements Formatter {

    static  {
        try{
             ip= InetAddress.getLocalHost().getHostAddress();

        }catch (Exception e){//不处理，取不到
            ip="0:0:0:0";
        }
    }
    private   static String ip;

    public static ObjectMapper getObjectMapper() {
        if(objectMapper==null){
            objectMapper=SpringBeanTools.getBean(ObjectMapper.class);
        }
        return objectMapper;
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        MessageFormatter.objectMapper = objectMapper;
    }

    private   static ObjectMapper objectMapper;
    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        MessageFormatter.ip = ip;
    }

    public static String getAppname() {
        if(appname==null){
            appname=SpringBeanTools.getBean(ZipkinProperties.class).getServiceName();
        }
        return appname;
    }

    public static void setAppname(String appname) {
        MessageFormatter.appname = appname;
    }

    private  static  String appname;
    @Override
    public String format(ILoggingEvent event) {

        LogEntity logEntity=new LogEntity();
        logEntity.setTraceId(MDC.get("traceId"));
        logEntity.setSpanId(MDC.get("spanId"));
        logEntity.setIP(ip);
        logEntity.setAppName(getAppname());
        logEntity.setLevel(event.getLevel().levelStr);
        logEntity.setLogger(event.getLoggerName());
        logEntity.setLocation(event.getCallerData()[0].toString());
        logEntity.setTimestamp(LocalDateTime.now());
        logEntity.setMessage(event.getFormattedMessage());
        if(event.getThrowableProxy()!=null){//error日志要记录堆栈信息
            StringBuilder stringBuilder=new StringBuilder();
            appendStackTrace(stringBuilder,event.getThrowableProxy());

            logEntity.setStackInfo(stringBuilder.toString());
        }
        return JsonUtil.bean2Json(logEntity);
    }

    private void appendStackTrace(StringBuilder log, IThrowableProxy proxy) {

            Stream<StackTraceElementProxy> trace = Arrays.stream(proxy.getStackTraceElementProxyArray());

            trace.forEach(step -> {
                String string = step.toString();

                log.append(CoreConstants.TAB).append(string);

                ThrowableProxyUtil.subjoinPackagingData(log, step);

                log.append(CoreConstants.LINE_SEPARATOR);
            });

            trace.close();

    }


}