package com.xmair.core.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_weixin_user")
public class TBWeixinUser {
    @Id
    @Column(name = "OPENID")
    private String openid;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "APPID")
    private String appid;

    @Column(name = "SUBSCRIBE")
    private String subscribe;

    @Column(name = "SUB_TIME")
    private Date subTime;

    /**
     * @return OPENID
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * @return NICKNAME
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * @return LANGUAGE
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * @return CITY
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return PROVINCE
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * @return COUNTRY
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * @return APPID
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    /**
     * @return SUBSCRIBE
     */
    public String getSubscribe() {
        return subscribe;
    }

    /**
     * @param subscribe
     */
    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe == null ? null : subscribe.trim();
    }

    /**
     * @return SUB_TIME
     */
    public Date getSubTime() {
        return subTime;
    }

    /**
     * @param subTime
     */
    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }
}