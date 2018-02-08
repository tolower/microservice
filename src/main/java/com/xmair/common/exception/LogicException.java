package com.xmair.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

*
 * 业务逻辑异常类 */
public class LogicException extends RuntimeException {

    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(LogicException.class);

    /**
     * 错误消息内容
     */
    protected String errMsg;
    /**
     * 错误码
     */
    protected String errCode;


    /**
     * 获取错误消息内容
     * 根据errCode从redis内获取未被格式化的错误消息内容
     * 并通过String.format()方法格式化错误消息以及参数
     *
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
     * @param params  错误参数列表
     */
    public LogicException(String errCode, String... params) {
        String[] param= params;
        this.errCode = errCode;
        //获取格式化后的异常消息内容
        this.errMsg = ErrorMessageTools.getErrorMessage(errCode, param);
        //错误信息
        logger.error("系统遇到如下异常，异常码：{}>>>异常信息：{}", errCode, errMsg);
    }
}