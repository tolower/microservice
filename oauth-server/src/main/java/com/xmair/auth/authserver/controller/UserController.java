package com.xmair.auth.authserver.controller;

import com.xmair.auth.authserver.util.MemCacheUtil;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*根据accesstoken返回用户基本信息
*
* */
@RestController
@RequestMapping("/oauth2")
public class UserController {

    /* *
     * 客户端向认证服务器提交accesstoken,
     * @return  用户基本信息
        */
    @RequestMapping(value = "/userinfo",method = RequestMethod.GET)
    public String userinfo(String access_token){
       return   MemCacheUtil.get(access_token);
    }

}
