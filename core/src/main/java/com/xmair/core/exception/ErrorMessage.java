package com.xmair.core.exception;

import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.util.SpringBeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;


public class ErrorMessage {

    /*
国际化资源文件工具类，new 出来的对象无法直接使用autowired，使用springtool工具
* */
    //@Autowired
    private MessageSource messageSource= SpringBeanTools.getBean(MessageSource.class);

    private String errorCode;
    private String message;

    private  BusinessExceptionEnum businessErrorCode;
    private  String bussinessErrorMessage;

    public String getBussinessErrorMessage() {
        return  bussinessErrorMessage;
    }

    public void setBussinessErrorMessage(String bussinessErrorMessage) {

        this.bussinessErrorMessage = bussinessErrorMessage;
    }


    public BusinessExceptionEnum getBusinessErrorCode() {
        return businessErrorCode;
    }

    public void setBusinessErrorCode(BusinessExceptionEnum businessErrorCode) {
        this.businessErrorCode = businessErrorCode;
        //默认采用的是acceptheaderLocaleResolver，检查http头的accept_language
        Locale locale1= LocaleContextHolder.getLocale();
        this.bussinessErrorMessage=messageSource.getMessage(businessErrorCode.toString(),null,locale1);
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  ErrorMessage(){}

    public  ErrorMessage(String code,String message){
        this.errorCode=code;
        this.message=message;
    }
    public  ErrorMessage(String code,String message,BusinessExceptionEnum bizExceptionCode){

        //默认采用的是acceptheaderLocaleResolver，检查http头的accept_language
        Locale locale1= LocaleContextHolder.getLocale();
        this.errorCode=code;
        this.message=message;
        this.businessErrorCode=bizExceptionCode;
        this.bussinessErrorMessage=messageSource.getMessage(businessErrorCode.toString(),null,locale1);
    }
}
