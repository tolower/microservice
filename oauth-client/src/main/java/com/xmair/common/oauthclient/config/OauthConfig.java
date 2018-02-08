package com.xmair.common.oauthclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "client.oauth2")
public  class OauthConfig {


    private  String clientID;

    private  String clientSecret;

    private  String clientScope;

    private  String callbackUrl;
    private  String authorizeUrl;
    private  String accessTokenUrl;
    private  String refreshTokenUrl;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientScope() {
        return clientScope;
    }

    public void setClientScope(String clientScope) {
        this.clientScope = clientScope;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getRefreshTokenUrl() {
        return refreshTokenUrl;
    }

    public void setRefreshTokenUrl(String refreshTokenUrl) {
        this.refreshTokenUrl = refreshTokenUrl;
    }

    public String getUserinfoUrl() {
        return userinfoUrl;
    }

    public void setUserinfoUrl(String userinfoUrl) {
        this.userinfoUrl = userinfoUrl;
    }

    private  String userinfoUrl;

}

