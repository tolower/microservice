package com.xmair.restapi.config;

import com.xmair.core.exception.ErrorMessage;
import com.xmair.core.exception.ExceptionEnum;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*全局异常处理类*/
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
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

        return  new ResultBean<>(ExceptionEnum.ARGUMENTS_INVALID,"arguments invalid",fieldErrors);

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
        result.setCode(ExceptionEnum.SERVER_ERROR);
        result.setMessage(e.getMessage());
        return result;
    }



}
