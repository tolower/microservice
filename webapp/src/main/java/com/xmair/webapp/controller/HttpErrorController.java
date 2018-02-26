package com.xmair.webapp.controller;

import com.xmair.core.util.ResultBean;
import com.xmair.core.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.ResponseEntity;
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
    public ResultBean<String> handleError(){
        ResultBean<String> result=new ResultBean<String>();
        result.setCode(ResultCodeEnum.PAGE_404.toString());
        result.setMessage("找不到该网页");
        return result;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
