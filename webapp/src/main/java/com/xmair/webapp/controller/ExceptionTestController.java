package com.xmair.webapp.controller;

import com.xmair.core.exception.ResultCodeEnum;
import com.xmair.core.exception.BusinessException;
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
    public String index() throws BusinessException {
        /**
         * 模拟用户不存在
         * 抛出业务逻辑异常
         */
        if (true) {
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.toString(),"111");
        }
        return "ttttttttttttttt";
    }


}
