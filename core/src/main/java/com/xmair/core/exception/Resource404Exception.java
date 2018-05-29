package com.xmair.core.exception;

public class Resource404Exception extends BaseException {

    public Resource404Exception(Throwable cause)
    {


        super(ExceptionEnum.RESOURCE_NOT_FOUND, cause);

    }

    public  Resource404Exception(String message){
        super(message);
        setErrorCode(ExceptionEnum.RESOURCE_NOT_FOUND);
    }
}