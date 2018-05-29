package com.xmair.core.exception;

public abstract class BaseException extends  RuntimeException{

    /**
     * 错误编码
     */
    private ExceptionEnum errorCode;

    private  BusinessExceptionEnum businessExceptionEnum;

    public BusinessExceptionEnum getBusinessExceptionEnum() {
        return businessExceptionEnum;
    }

    public void setBusinessExceptionEnum(BusinessExceptionEnum businessExceptionEnum) {
        this.businessExceptionEnum = businessExceptionEnum;
    }



    public ExceptionEnum getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(ExceptionEnum errorCode)
    {
        this.errorCode = errorCode;
    }

    /**
     * 构造一个基本异常.默认为业务异常
     *
     * @param message
     *            信息描述
     */
    public BaseException(String message)
    {
        super(message);

        setErrorCode(ExceptionEnum.BUSINESS_ERROR);
    }

    public BaseException(ExceptionEnum resultCodeEnum, Throwable cause)
    {

        super(resultCodeEnum.toString(), cause);
        setErrorCode(resultCodeEnum);

    }


    public  ErrorMessage getErrorMessage(){
        ErrorMessage error = new ErrorMessage(getErrorCode().toString() ,this.getMessage());
       // error.setBusinessErrorCode();

        return  error;
    }
}
