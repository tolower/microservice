package com.xmair.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @Transactional
    @RequestMapping("/index")
    public String index(){

        return  "index";
    }
}
