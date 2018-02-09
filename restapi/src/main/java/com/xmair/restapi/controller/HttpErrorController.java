package com.xmair.restapi.controller;

import com.xmair.core.exception.ErrorCodeEnum;
import com.xmair.core.exception.ExceptionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HttpErrorController implements ErrorController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/error")
    @ResponseBody
    public ExceptionResult handleError(){
        ExceptionResult result=new ExceptionResult();
        result.setErrCode(ErrorCodeEnum.PAGE_404.toString());
        result.setErrMsg("找不到该服务，请确认api地址");
        return result;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
