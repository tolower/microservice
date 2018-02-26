package com.xmair.core.entity;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;


/**
 * <p>
 * 
 *${remark}
 *
 * </p>
 * 
 * @author wuzuquan
 * @date 2018-02-26 12:45:47
 * @version
 */
@Table(name = "tb_weixin_user")
public class TbWeixinUser implements Serializable {



    @Length(max=40,message="LANGUAGE 长度不能超过40")
    @Column(name = "LANGUAGE")
	private String language;
	


    @Length(max=100,message="NICKNAME 长度不能超过100")
    @Column(name = "NICKNAME")
	private String nickname;
	


    @Length(max=50,message="OPENID 长度不能超过50")
    @NotNull(message = "OPENID not allow null")
    @Id
    @Column(name = "OPENID")
	private String openid;
	


    @Length(max=50,message="CITY 长度不能超过50")
    @Column(name = "CITY")
	private String city;
	


    @Length(max=50,message="COUNTRY 长度不能超过50")
    @Column(name = "COUNTRY")
	private String country;
	


    @Length(max=50,message="APPID 长度不能超过50")
    @Column(name = "APPID")
	private String appid;
	


    @Length(max=5,message="SEX 长度不能超过5")
    @Column(name = "SEX")
	private String sex;
	


    @NotNull(message = "SUB_TIME not allow null")
    @Column(name = "SUB_TIME")
	private Date subTime;
	


    @Length(max=50,message="PROVINCE 长度不能超过50")
    @Column(name = "PROVINCE")
	private String province;
	


    @Length(max=5,message="SUBSCRIBE 长度不能超过5")
    @Column(name = "SUBSCRIBE")
	private String subscribe;
	
		
	public String getLanguage() {
        return language;
    }

	public void setLanguage(String language) {
    	 this.language = language;
	}
		
	public String getNickname() {
        return nickname;
    }

	public void setNickname(String nickname) {
    	 this.nickname = nickname;
	}
		
	public String getOpenid() {
        return openid;
    }

	public void setOpenid(String openid) {
    	 this.openid = openid;
	}
		
	public String getCity() {
        return city;
    }

	public void setCity(String city) {
    	 this.city = city;
	}
		
	public String getCountry() {
        return country;
    }

	public void setCountry(String country) {
    	 this.country = country;
	}
		
	public String getAppid() {
        return appid;
    }

	public void setAppid(String appid) {
    	 this.appid = appid;
	}
		
	public String getSex() {
        return sex;
    }

	public void setSex(String sex) {
    	 this.sex = sex;
	}
		
	public Date getSubTime() {
        return subTime;
    }

	public void setSubTime(Date subTime) {
    	 this.subTime = subTime;
	}
		
	public String getProvince() {
        return province;
    }

	public void setProvince(String province) {
    	 this.province = province;
	}
		
	public String getSubscribe() {
        return subscribe;
    }

	public void setSubscribe(String subscribe) {
    	 this.subscribe = subscribe;
	}
	}