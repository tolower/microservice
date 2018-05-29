package com.xmair.core.exception;

/*
* 异常代码枚举
* */
public enum BusinessExceptionEnum {

    DBerror("执行数据库异常"),
    CreateOrderFail("创建订单失败。。。"),
    RESOURCE_NOT_FOUND("resource_not_found"),
    ARGUMENTS_INVALID("args invalid"),
    AUTHORIZATION_INVALID("args invalid"),
    BUSINESS_ERROR("business_error"),
    SERVER_ERROR("server_error");

    private BusinessExceptionEnum(String businessMessage){
        this.businessMessage=businessMessage;
    }

    public String getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(String businessMessage) {
        this.businessMessage = businessMessage;
    }

    // 成员变量
    private String businessMessage;


}
