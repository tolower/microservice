package com.xmair.auth.authserver.controller;

import com.xmair.auth.authserver.Entity.User;
import com.xmair.auth.authserver.service.UserService;
import com.xmair.auth.authserver.util.MemCacheUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.issuer.UUIDValueGenerator;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URISyntaxException;
import java.util.Date;


@Controller
@RequestMapping(value="oauth2")
public class OauthController {
    private static Logger logger = LoggerFactory.getLogger(OauthController.class);

    @RequestMapping(value = "/authorize")
    public Object authorize( HttpServletRequest request,Model model , HttpServletResponse response)
            throws URISyntaxException, OAuthSystemException {
        logger.info("sessionid: "+request.getSession().getId() );
        try {

            //构建OAuth 授权请求
            OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);

            //检查传入的客户端id是否正确
            if (!MemCacheUtil.hasKey(oauthRequest.getClientId())) {
                OAuthResponse oAuthResponse =
                        OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                                .setError(OAuthError.TokenResponse.INVALID_CLIENT)
                                .setErrorDescription("非法的客户端ID")
                                .buildJSONMessage();
                model.addAttribute("errorMsg", oAuthResponse.getBody());
                return "/oauth2/error";
            }
            //查询客户端Appkey应用的信息
            String clientName= MemCacheUtil.get(oauthRequest.getClientId());
            model.addAttribute("clientName",clientName);
            model.addAttribute("response_type",oauthRequest.getResponseType());
            model.addAttribute("client_id",oauthRequest.getClientId());
            model.addAttribute("redirect_uri",oauthRequest.getRedirectURI());
            model.addAttribute("scope1",oauthRequest.getScopes().toArray()[0]);

            //生成授权码code,授权码生成器： UUIDValueGenerator OR MD5Generator
            String authorizationCode = new OAuthIssuerImpl(new UUIDValueGenerator()).authorizationCode();
            //把授权码存入缓存 code<==>castgc
            Cookie[] cookies = request.getCookies();
            String castgc=null;

                for (int i = 0; i < cookies.length; i++) {
                    Cookie c = cookies[i];
                    if (c.getName().equalsIgnoreCase("castgc")) {
                        castgc = c.getValue();
                        break;
                    }
                }
            MemCacheUtil.set(authorizationCode,castgc);
            //构建oauth2授权返回信息
            OAuthResponse oauthResponse = OAuthASResponse
                    .authorizationResponse(request,HttpServletResponse.SC_FOUND)
                    .setCode(authorizationCode)
                    .location(oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI))
                    .buildQueryMessage();
            //申请令牌成功重定向到客户端页
            return "redirect:"+oauthResponse.getLocationUri();
        } catch(OAuthProblemException ex) {
            OAuthResponse oauthResponse = OAuthResponse
                    .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                    .error(ex)
                    .buildJSONMessage();
            logger.error("oauthRequest.getRedirectURI() : " + ex.getRedirectUri() + " oauthResponse.getBody() : " + oauthResponse.getBody());
            model.addAttribute("errorMsg", oauthResponse.getBody());
            return  "/oauth2/error";
    }
    }


}
