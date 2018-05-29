package com.xmair.core.exception;

/*

*
 * 业务逻辑异常类 */
public class Business500Exception extends BaseException {

    public Business500Exception(Throwable cause)
    {


        super(ExceptionEnum.BUSINESS_ERROR, cause);
        setBusinessExceptionEnum(BusinessExceptionEnum.SERVER_ERROR);
    }

    public Business500Exception(String message){
        super(message);
        setErrorCode(ExceptionEnum.BUSINESS_ERROR);
    }

    public Business500Exception(BusinessExceptionEnum bizEceptionEnum){
        super(ExceptionEnum.BUSINESS_ERROR.toString());
        setBusinessExceptionEnum(bizEceptionEnum);
    }

    @Override
    public ErrorMessage getErrorMessage() {
        ErrorMessage errorMessage= super.getErrorMessage();
        errorMessage.setBusinessErrorCode(this.getBusinessExceptionEnum());

        return  errorMessage;
    }
}