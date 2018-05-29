package com.xmair.core.configuration.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.xmair.core.util.JsonUtil;
import org.slf4j.MDC;

import java.net.InetAddress;

public class MessageFormatter implements Formatter {

    private static   String getIp(){
        try{
            String ip= InetAddress.getLocalHost().getHostAddress();
            return  ip;
        }catch (Exception e){//不处理，取不到
            return  "0:0:0:0";
        }
    }
    public  static String ip=getIp();

    @Override
    public String format(ILoggingEvent event) {

        LogEntity logEntity=new LogEntity();
        logEntity.setTraceId(MDC.get("X-B3-TraceId"));
        logEntity.setSpanId(MDC.get("X-B3-SpanId"));
        logEntity.setIP(ip);
        logEntity.setLevel(event.getLevel().levelStr);
        logEntity.setLogger(event.getLoggerName());
        logEntity.setTimestamp(event.getTimeStamp());
        logEntity.setMessage(event.getFormattedMessage());
        if(event.getThrowableProxy()!=null){//error日志要记录堆栈信息的第一行
            logEntity.setStackInfo(event.getThrowableProxy().getStackTraceElementProxyArray()[0].toString());
        }

        return JsonUtil.bean2Json(logEntity);
    }

}