package com.xmair.restapi.controller;

import com.xmair.core.util.ResultBean;
import com.xmair.core.exception.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HttpErrorController implements ErrorController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/error")
    @ResponseBody
    public ResultBean<String> handleError(){
        ResultBean<String> result=new ResultBean<String>();
        result.setCode(ResultCodeEnum.RESOURCE_NOT_FOUND);
        result.setMessage("找不到该服务，请确认api地址");
        return result;
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
