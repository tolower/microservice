package com.xmair.oauth.controller;

import com.xmair.oauth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/login")
@Controller
public class LoginController {

    @Autowired
    private  HttpServletRequest request;

    @Autowired
    private  HttpServletRequest response;

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login() {
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (!userName.equals("") && password != "") {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
            map.put("username",userName);
        } else {
            map.put("result", "0");
        }
        return map;
    }

    @RequestMapping("/login")
    public ModelAndView index2() {
        return  new ModelAndView();
    }
}