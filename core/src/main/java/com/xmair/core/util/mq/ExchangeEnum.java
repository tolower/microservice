package com.xmair.core.util.mq;


public enum ExchangeEnum
{
    /**
     * 用户注册交换配置枚举
     */
    USER_REGISTER("user.register.topic.exchange");
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    ExchangeEnum(String value) {

        this.value = value;
    }
}
