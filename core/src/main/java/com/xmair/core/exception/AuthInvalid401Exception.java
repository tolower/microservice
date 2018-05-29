package com.xmair.core.exception;

public class AuthInvalid401Exception extends  BaseException {

    public AuthInvalid401Exception(Throwable cause)
    {


        super(ExceptionEnum.AUTHORIZATION_INVALID, cause);

    }

    public AuthInvalid401Exception(String message){
        super(message);
        setErrorCode(ExceptionEnum.AUTHORIZATION_INVALID);
    }
}
