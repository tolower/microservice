package com.xmair.core.exception;

/*无权限*/
public class Forbidden403Exception extends  BaseException {

    public Forbidden403Exception(Throwable cause)
    {


        super(ExceptionEnum.AUTH_FORBIDDEN, cause);

    }

    public Forbidden403Exception(String message){
        super(message);
        setErrorCode(ExceptionEnum.AUTH_FORBIDDEN);
    }
}
