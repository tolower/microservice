package com.xmair.oauth.oauthclient2.Interceptor;


import com.xmair.oauth.oauthclient2.entity.User;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class OauthInterceptor implements HandlerInterceptor {

    private  static Map<String,String> map=new HashMap<String,String>();

    String clientID="appid2";
    String clientSecret="appkey2";
    String clientScope="user";

    String callbackUrl = "http://localhost:8002/oauth2/callback";

    String authorizeUrl="http://localhost:8080/oauth2/authorize";
    String accessTokenUrl="http://localhost:8080/oauth2/access_token";
    String refreshTokenUrl="http://localhost:8080/oauth2/refresh_token";
    String userinfoUrl="http://localhost:8080/oauth2/userinfo";
    /*
        response_type：表示授权类型，必选项，此处的值固定为"code"
        client_id：表示客户端的ID，必选项
        redirect_uri：表示重定向URI，可选项
        scope：表示申请的权限范围，可选项
        state：表示客户端的当前状态，可以指定任意值，认证服务器会原封不动地返回这个值
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag=true;
        User user =(User)   request.getSession().getAttribute("user");
        if(user ==null){//用户未登陆
            //记录用户请求的url
            map.put(request.getRequestedSessionId(),request.getRequestURI());
            try {

                OAuthClientRequest oauthRequest = OAuthClientRequest
                        .authorizationLocation(authorizeUrl)
                        .setResponseType(OAuth.OAUTH_CODE)
                        .setClientId(clientID)
                        .setRedirectURI(callbackUrl)
                        .setScope(clientScope)
                        .buildQueryMessage();
                response.sendRedirect(oauthRequest.getLocationUri());
            } catch (OAuthSystemException e) {

                e.printStackTrace();
            }
            flag=false;
        }else {
            flag=true;
        }

        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
