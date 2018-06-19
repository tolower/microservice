package com.xmair.restapi.config;

import com.xmair.core.exception.Business500Exception;
import com.xmair.core.exception.ErrorMessage;
import com.xmair.core.exception.ExceptionEnum;
import com.xmair.core.exception.Resource404Exception;
import com.xmair.core.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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

    @Autowired
    private MessageSource messageSource;
    /**
     * 统一处理bean验证抛出的参数校验异常
     * 参数校验失败，统一采用warn记录日志
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorMessage> validExceptionHandler(BindException e, WebRequest request, HttpServletResponse response) {

        logger.warn("参数校验失败,{}", JsonUtil.bean2Json(e.getTarget()));
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setErrorCode(ExceptionEnum.ARGUMENTS_INVALID.toString());
        errorMessage.setMessage(JsonUtil.bean2Json(fieldErrors));
        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);

    }


    /*找不到资源*/
    @ExceptionHandler(Resource404Exception.class)
    public ResponseEntity<ErrorMessage> ResourceNotFound(Resource404Exception e){

        logger.error(e.getMessage(),e);
        return new ResponseEntity<ErrorMessage>(e.getErrorMessage(),HttpStatus.NOT_FOUND);
    }

    /*业务处理异常或者服务器异常*/
    @ExceptionHandler(Business500Exception.class)
    public ResponseEntity<ErrorMessage> BusinessException(Business500Exception e){
        logger.error(e.getMessage(),e);
        ErrorMessage errorMessage=e.getErrorMessage();

      //  errorMessage.setBussinessErrorMessage(
        //        messageSource.getMessage(e.getBusinessExceptionEnum().toString(),null,loca));
        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ResponseEntity<ErrorMessage> runtimeExceptionHandler(Exception e) {
        logger.error("运行时异常：【{}】", e.getMessage(),e);
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setErrorCode(ExceptionEnum.SERVER_ERROR.toString());
        errorMessage.setMessage("未捕获的服务器异常："+e.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
