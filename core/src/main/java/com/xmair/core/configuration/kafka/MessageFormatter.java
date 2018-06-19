package com.xmair.core.configuration.kafka;

import ch.qos.logback.classic.spi.*;
import ch.qos.logback.core.CoreConstants;
import com.xmair.core.configuration.zipkin.ZipkinProperties;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.SpringBeanTools;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
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
    public  static String ip;

    private  static  String appname;
    @Override
    public String format(ILoggingEvent event) {

        LogEntity logEntity=new LogEntity();
        logEntity.setTraceId(MDC.get("traceId"));
        logEntity.setSpanId(MDC.get("spanId"));
        logEntity.setIP(ip);
        logEntity.setAppName(SpringBeanTools.getBean(ZipkinProperties.class).getServiceName());
        logEntity.setLevel(event.getLevel().levelStr);
        logEntity.setLogger(event.getLoggerName());
        logEntity.setTimestamp(event.getTimeStamp());
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