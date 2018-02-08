package com.xmair.webapp.controller;

import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.util.MemCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/login")
@Controller
public class LoginController {

    @Autowired
    private  HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private EmpDataMapper userMapper;

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public String login() {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            request.setAttribute("error", "登录失败:用户名或密码不能为空");
            return "redirect:/login/login";
        }

            EmpData user = userMapper.selectByPrimaryKey(username);
            // todo 初始化会话信息
            request.getSession().setAttribute("pcode",user.getMfId());
            //跳转回初始请求地址
            return "redirect:"+ MemCacheUtil.get(request.getSession().getId());

    }

    @RequestMapping("/login")
    public ModelAndView index2() {
        return  new ModelAndView();
    }
}