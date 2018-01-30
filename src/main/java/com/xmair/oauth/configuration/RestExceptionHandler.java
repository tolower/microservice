package com.xmair.oauth.configuration;

import com.xmair.oauth.exception.LogicException;
import com.xmair.oauth.util.ApiResult;
import com.xmair.oauth.util.ApiResultGenerator;
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
    public ApiResult runtimeExceptionHandler(Exception e) {
        logger.error("运行时异常：【{}】", e.getMessage());
        ApiResult result=new ApiResult();
        result.setErrCode("SystemError");
        result.setErrMsg(e.getMessage());
        return result;
    }

    /**
     * 处理业务逻辑异常
     *
     * @param e 业务逻辑异常对象实例
     * @return 逻辑异常消息内容
     */
    @ExceptionHandler(LogicException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResult logicException(LogicException e) {
        logger.error("遇到业务逻辑异常：【{}】", e.getErrCode());
        // 返回响应实体内容
        ApiResult result=new ApiResult();
        result.setErrCode(e.getErrCode());
        result.setErrMsg(e.getErrMsg());
        return result;
    }

}
