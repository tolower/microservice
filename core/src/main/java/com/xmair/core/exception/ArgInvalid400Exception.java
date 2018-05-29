package com.xmair.core.exception;

public class ArgInvalid400Exception extends BaseException {

    public ArgInvalid400Exception(Throwable cause)
    {


        super(ExceptionEnum.ARGUMENTS_INVALID, cause);

    }

    public ArgInvalid400Exception(String message){
        super(message);
        setErrorCode(ExceptionEnum.ARGUMENTS_INVALID);
    }
}