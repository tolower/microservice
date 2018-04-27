package com.xmair.webapp.config;

import com.xmair.core.exception.BusinessException;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.ResultBean;
import com.xmair.core.exception.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class WebAppExceptionHandler {
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

        return  new ResultBean<>(ResultCodeEnum.ARGUMENTS_INVALID,"arguments invalid",fieldErrors);

    }


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
        result.setCode(ResultCodeEnum.SERVER_ERROR);
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
        logger.error("遇到业务逻辑异常：【{}】", e.getErrCode(),e);
        // 返回响应实体内容
        ResultBean<String> result=new ResultBean<String>(ResultCodeEnum.BUSINESS_ERROR,e.getErrMsg(),"业务异常");
        return result;
    }


}
