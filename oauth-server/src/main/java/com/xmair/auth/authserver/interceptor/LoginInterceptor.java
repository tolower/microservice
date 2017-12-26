package com.xmair.auth.authserver.interceptor;


import com.xmair.auth.authserver.util.MemCacheUtil;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    //验证用户是否已登录:1、校验是否存在castgc cookie是否存在；2,校验castgc是否在服务器缓存，防止伪造

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isLogin=false;
        Cookie[] cookies = request.getCookies();
        String castgc=null;
        if(cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equalsIgnoreCase("castgc")) {
                    castgc = c.getValue();
                    break;
                }
            }
            if(MemCacheUtil.get(castgc)!=null){
                isLogin=true;
            }
        }
        if(isLogin==false) {
            String strBackUrl = "http://" + request.getServerName() //服务器地址
                    + ":"
                    + request.getServerPort()           //端口号
                    + request.getContextPath()      //项目名称
                    + request.getServletPath()      //请求页面或其他地址
                    + "?" + (request.getQueryString()); //参数
            MemCacheUtil.set(request.getSession().getId(),strBackUrl);
            //登录未登陆跳转到登陆页
            response.sendRedirect("/oauth2/login");

        }

        return isLogin;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
    }