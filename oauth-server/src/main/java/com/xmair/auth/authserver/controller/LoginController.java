package com.xmair.auth.authserver.controller;


import com.xmair.auth.authserver.Entity.User;
import com.xmair.auth.authserver.service.UserService;
import com.xmair.auth.authserver.util.MemCacheUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/oauth2")
@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String login() {
        if ("get".equalsIgnoreCase(request.getMethod())) {
            request.setAttribute("error", "非法的请求");
            return "redirect:/oauth2/login";
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            request.setAttribute("error", "登录失败:用户名或密码不能为空");
            return "redirect:/oauth2/login";
        }
        try {
            // todo写登录逻辑
            String casTGC = DigestUtils.sha1Hex(username + new Date().toString());
            User user = UserService.findByUsername(username);
            //写入tgc cookie
            Cookie cookie = new Cookie("castgc", casTGC);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            //castgc与userid映射
            MemCacheUtil.set(casTGC, username);
            return "redirect:"+ MemCacheUtil.get(request.getSession().getId());
        } catch (Exception e) {
            request.setAttribute("error", "登录失败:" + e.getClass().getName());
            return "/oauth2/login";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView index2() {
        return new ModelAndView();
    }
}
