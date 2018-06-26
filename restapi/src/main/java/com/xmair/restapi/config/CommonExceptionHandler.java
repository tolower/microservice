package com.xmair.restapi.config;

import com.xmair.core.exception.BusinessException;
import com.xmair.core.exception.ExceptionEnum;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.ResultBean;
import kafka.utils.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*全局异常处理类*/
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class CommonExceptionHandler {
    /**
     * logback new instance
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 统一处理bean验证抛出的参数校验异常
     * 参数校验失败，统一采用warn记录日志
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(BindException.class)
    public ResultBean<List<FieldError>> validExceptionHandler(BindException e, WebRequest request, HttpServletResponse response) {

        logger.warn("参数校验失败,{}", JsonUtil.bean2Json(e.getTarget()));
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();

        return  new ResultBean<>(ExceptionEnum.ARGUMENTS_INVALID,null,"arguments invalid",fieldErrors);

    }


    /**
     * 统一拦截处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResultBean<String> validExceptionHandler(BusinessException e) {
        logger.warn("业务异常：【{}】", e.getMessage(),e);
        ResultBean<String> result=new ResultBean<String>();
        result.setCode(ExceptionEnum.BUSINESS_ERROR.getCode());
        result.setErrStr(e.getErrCode());
        result.setMessage(e.getMessage());
        result.setData(JsonUtil.bean2Json(e.getData()));
        return result;
    }

    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ResultBean<String> runtimeExceptionHandler(Exception e) {
        logger.error("运行时异常：【{}】", e.getMessage(),e);
        ResultBean<String> result=new ResultBean<String>();
        result.setCode(ExceptionEnum.SERVER_ERROR.getCode());
        result.setMessage(e.getMessage()+"-- traceid:"+ MDC.get("traceId"));
        return result;
    }



}
