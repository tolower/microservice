package com.xmair.core.util;

/*
* 异常代码枚举
* */
public enum ResultCodeEnum {

    SUCCESS("success"),
    RESOURCE_NOT_FOUND("resource_not_found"),
    ARGUMENTS_INVALID("args invalid"),
    BUSINESS_ERROR("business_error"),
    SERVER_ERROR("server_error");

    private ResultCodeEnum(String code){
        this.code=code;
    }
    // 成员变量
    private String code;
}
