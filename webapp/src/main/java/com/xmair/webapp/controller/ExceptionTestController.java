package com.xmair.webapp.controller;

import com.xmair.core.exception.Business500Exception;
import com.xmair.core.exception.BusinessExceptionEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exception")
public class ExceptionTestController {

    /**
     * 首页方法
     *
     * @return
     */
    @RequestMapping(value = "/test")
    public String index() throws Business500Exception {
        /**
         * 模拟用户不存在
         * 抛出业务逻辑异常
         */
        if (true) {
            throw new Business500Exception(BusinessExceptionEnum.DBerror);
        }
        return "ttttttttttttttt";
    }


}
