package com.xmair.core.exception;

public class ErrorMessage {
    private String errorCode;
    private String message;
    private  BusinessExceptionEnum businessErrorCode;

    public String getBussinessErrorMessage() {
        if(businessErrorCode==null){
            return  null;
        }
        return businessErrorCode.getBusinessMessage();
    }

    public void setBussinessErrorMessage(String bussinessErrorMessage) {
        this.bussinessErrorMessage = bussinessErrorMessage;
    }

    private  String bussinessErrorMessage;
    public BusinessExceptionEnum getBusinessErrorCode() {
        return businessErrorCode;
    }

    public void setBusinessErrorCode(BusinessExceptionEnum businessErrorCode) {
        this.businessErrorCode = businessErrorCode;
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
        this.errorCode=code;
        this.message=message;
        this.businessErrorCode=bizExceptionCode;
    }
}
