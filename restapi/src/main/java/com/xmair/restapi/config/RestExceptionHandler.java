package com.xmair.restapi.config;

import com.xmair.core.exception.BusinessException;
import com.xmair.core.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    /**
     * logback new instance
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ResultBean<String> runtimeExceptionHandler(Exception e) {
        logger.error("运行时异常：【{}】", e.getMessage());
        ResultBean<String> result=new ResultBean<String>();
        result.setCode("SystemError");
        result.setMessage(e.getMessage());
        return result;
    }

    /**
     * 处理业务逻辑异常
     *
     * @param e 业务逻辑异常对象实例
     * @return 逻辑异常消息内容
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResultBean<String> logicException(BusinessException e) {
        logger.error("遇到业务逻辑异常：【{}】", e.getErrCode());
        // 返回响应实体内容
        ResultBean<String> result=new ResultBean<String>();
        result.setCode(e.getErrCode());
        result.setMessage(e.getErrMsg());
        return result;
    }

}
