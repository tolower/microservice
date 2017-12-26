package com.xmair.oauth.oauthclient.controller;

import com.xmair.oauth.oauthclient.config.OauthConfig;
import com.xmair.oauth.oauthclient.entity.User;
import com.xmair.oauth.oauthclient.util.HttpClientUtil;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/oauth2")
public class CallbackController {

    @Autowired
    OauthConfig oauthConfig;
    private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

      /*
        grant_type：表示使用的授权模式，必选项，此处的值固定为"authorization_code"
        code：表示上一步获得的授权码，必选项。
        redirect_uri：表示重定向URI，必选项，且必须与A步骤中的该参数值保持一致
        client_id：表示客户端ID，必选项
    */
    /**
     * 获得令牌
     * @return oauth_callback?code=1234
     */
    @RequestMapping(value = "/callback" ,method = RequestMethod.GET)
    public void getToken(HttpServletRequest request, HttpServletResponse response, Model model) throws OAuthProblemException {
        OAuthAuthzResponse oauthAuthzResponse = null;
        try {
            oauthAuthzResponse = OAuthAuthzResponse.oauthCodeAuthzResponse(request);
            String code = oauthAuthzResponse.getCode();
            OAuthClientRequest oauthClientRequest = OAuthClientRequest
                    .tokenLocation(oauthConfig.getAccessTokenUrl())
                    .setGrantType(GrantType.AUTHORIZATION_CODE)
                    .setClientId(oauthConfig.getClientID())
                    .setClientSecret(oauthConfig.getClientSecret())
                    .setRedirectURI(oauthConfig.getCallbackUrl())
                    .setCode(code)
                    .buildQueryMessage();
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

            //获取access token
            OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(oauthClientRequest, OAuth.HttpMethod.POST);
            String accessToken = oAuthResponse.getAccessToken();
            String refreshToken= oAuthResponse.getRefreshToken();
            Long expiresIn = oAuthResponse.getExpiresIn();
            logger.info("accessToken: "+accessToken +" refreshToken: "+refreshToken +" expiresIn: "+expiresIn );

            //根据accesstoken获取用户基本信息,写入sessoin信息,跳转回用户最初请求的url
            String userid= HttpClientUtil.sendHttpGet(oauthConfig.getUserinfoUrl()+"?access_token="+oAuthResponse.getAccessToken());
            User user =new User();
            user.setName(userid);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/userinfo/index");
        } catch (Exception ex) {
            logger.error("getToken OAuthSystemException : " + ex.getMessage());
            model.addAttribute("errorMsg",  ex.getMessage());
            //return "/userinfo/error";
        }
    }
}
