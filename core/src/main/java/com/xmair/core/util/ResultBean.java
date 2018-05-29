package com.xmair.core.util;

import com.xmair.core.exception.ExceptionEnum;

import java.io.Serializable;

/*
* 定义统一标准的接口规范
* */
public class  ResultBean<T> implements Serializable{
    /**
     * 编号
     */
    private ExceptionEnum code= ExceptionEnum.SUCCESS;
    /**
     * 消息内容
     */
    private String message="success";

    /**
     数据内容
     */
    private  T data;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionEnum getCode() {
        return code;
    }

    public void setCode(ExceptionEnum code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public ResultBean(ExceptionEnum code, String message, T data) {

        this.code=code;
        this.message=message;
        this.data=data;
    }

    public  ResultBean(){}
    public  ResultBean(T data){
        super();
        this.data=data;
    }
    public ResultBean(Throwable e){
        this.code= ExceptionEnum.SERVER_ERROR;
        this.message=e.getMessage();
    }
}
