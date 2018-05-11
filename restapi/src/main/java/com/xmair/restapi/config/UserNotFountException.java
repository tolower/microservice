package com.xmair.restapi.config;

public class UserNotFountException extends RuntimeException{
    private String userId;

    public UserNotFountException(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
