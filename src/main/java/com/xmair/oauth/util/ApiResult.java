package com.xmair.oauth.util;

import java.io.Serializable;
import java.util.Date;

public class ApiResult implements Serializable{

    /**
     * 错误消息内容
     */
    private String errMsg;
    /**
     * 错误码
     */
    private String errCode;
    //返回结构
    private Object result;
    //查询出的结构总数

    //接口响应时间毫秒单位
    private Date rtt;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Date getRtt() {
        return rtt;
    }

    public void setRtt(Date rtt) {
        this.rtt = rtt;
    }
}
