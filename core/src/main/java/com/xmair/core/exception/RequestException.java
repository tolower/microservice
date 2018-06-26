package com.xmair.core.exception;

/**
 * Created by wd on 2016-7-20.
 */
//请求异常，客户端请求的参数不符合要求，一般为BUG，需要开发人员处理
public class RequestException extends Exception{
  private String errStr;

  public RequestException(String errStr, String errMsg){
    super(errMsg);
    this.errStr = errStr;
  }

  public String getErrStr() {
    return errStr;
  }

  public void setErrStr(String errStr) {
    this.errStr = errStr;
  }
}
