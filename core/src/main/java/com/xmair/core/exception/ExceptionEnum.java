package com.xmair.core.exception;

/*
* 异常代码枚举
* */
public enum ExceptionEnum {

    SUCCESS("success"),
    RESOURCE_NOT_FOUND("resource_not_found"),
    ARGUMENTS_INVALID("args invalid"),
    AUTHORIZATION_INVALID("auth invalid"),
    AUTH_FORBIDDEN("You are not permitted to do this operition."),
    BUSINESS_ERROR("business_error"),
    SERVER_ERROR("server_error");

    private ExceptionEnum(String code){
        this.code=code;
    }
    // 成员变量
    private String code;
}
