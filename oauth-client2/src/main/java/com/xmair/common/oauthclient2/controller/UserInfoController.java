package com.xmair.common.oauthclient2.controller;

import com.xmair.common.oauthclient2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private  HttpServletRequest request;

    @Autowired
    private  HttpServletRequest response;




    @RequestMapping(value = "/index")
    public ModelAndView index(){


        ModelAndView modelAndView = new ModelAndView();
        User user =(User)   request.getSession().getAttribute("user");
        modelAndView.addObject("userid",user.getName());

        return modelAndView;
    }

}
