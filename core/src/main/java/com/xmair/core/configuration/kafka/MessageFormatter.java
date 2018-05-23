package com.xmair.core.configuration.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.xmair.core.util.JsonUtil;
import org.slf4j.MDC;

import java.net.InetAddress;

public class MessageFormatter implements Formatter {



    @Override
    public String format(ILoggingEvent event) {

        LogEntity logEntity=new LogEntity();
        logEntity.setTraceId(MDC.get("X-B3-TraceId"));
        logEntity.setSpanId(MDC.get("X-B3-SpanId"));
        try{
       String ip= InetAddress.getLocalHost().getHostAddress();
        logEntity.setIP(ip);
        }catch (Exception e){//不处理，取不到
           logEntity.setIP("取不到IP");
        }
        logEntity.setLevel(event.getLevel().levelStr);
        logEntity.setLogger(event.getLoggerName());
        logEntity.setTimestamp(event.getTimeStamp());
        logEntity.setMessage(event.getFormattedMessage());
        return JsonUtil.bean2Json(logEntity);
    }

}