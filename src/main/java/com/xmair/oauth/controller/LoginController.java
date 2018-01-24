package com.xmair.oauth.controller;

import com.xmair.oauth.entity.EmpInfo;
import com.xmair.oauth.entity.User;
import com.xmair.oauth.mapper.framedb.EmpInfoMapper;
import com.xmair.oauth.service.UserService;
import com.xmair.oauth.util.MemCacheUtil;
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

@RequestMapping(value = "/login")
@Controller
public class LoginController {

    @Autowired
    private  HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private EmpInfoMapper userMapper;

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public String login() {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            request.setAttribute("error", "登录失败:用户名或密码不能为空");
            return "redirect:/login/login";
        }
        try {
            EmpInfo user = userMapper.getOne(username);
            // todo 初始化会话信息
            request.getSession().setAttribute("pcode",user.getMf_id());
            //跳转回初始请求地址
            return "redirect:"+ MemCacheUtil.get(request.getSession().getId());
        } catch (Exception e) {
            return "redirect:/login/login";
        }
    }
    @RequestMapping("/login")
    public ModelAndView index2() {
        return  new ModelAndView();
    }
}