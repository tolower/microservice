package com.xmair.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @Transactional
    @RequestMapping("/index")
    public String index(){

        return  "index";
    }
}
