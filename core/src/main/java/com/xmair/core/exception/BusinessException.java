package com.xmair.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

*
 * 业务逻辑异常类 */
public class BusinessException extends RuntimeException {

    /**
     * 错误消息内容
     */
    protected String errMsg;
    /**
     * 错误码
     */
    protected String errCode;


    @Override
    public String getMessage() {
        return errMsg;
    }

    /**
     * @return
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 获取错误码
     *
     * @return
     */
    public String getErrCode() {
        return errCode;
    }



    /**
     * 构造函数设置错误码以及错误参数列表
     *
     * @param errCode 错误码
     * @param message  错误参数列表
     */
    public BusinessException(String errCode, String message) {
        this.errCode = errCode;
        //获取格式化后的异常消息内容
        this.errMsg = message;
    

    }
}