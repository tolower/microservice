package com.xmair.core.entity;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


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
@Table(name = "user")
public class User implements Serializable {



    @Length(max=255,message="password 长度不能超过255")
    @Column(name = "password")
	private String password;
	


    @Length(max=45,message="name 长度不能超过45")
    @Column(name = "name")
	private String name;
	


    @Column(name = "photo")
	private byte[] photo;
	


    @NotNull(message = "id not allow null")
    @Id
    @Column(name = "id")
	private Integer id;
	


    @Length(max=45,message="passowrd 长度不能超过45")
    @Column(name = "passowrd")
	private String passowrd;
	


    @Column(name = "age")
	private Integer age;
	
		
	public String getPassword() {
        return password;
    }

	public void setPassword(String password) {
    	 this.password = password;
	}
		
	public String getName() {
        return name;
    }

	public void setName(String name) {
    	 this.name = name;
	}
		
	public byte[] getPhoto() {
        return photo;
    }

	public void setPhoto(byte[] photo) {
    	 this.photo = photo;
	}
		
	public Integer getId() {
        return id;
    }

	public void setId(Integer id) {
    	 this.id = id;
	}
		
	public String getPassowrd() {
        return passowrd;
    }

	public void setPassowrd(String passowrd) {
    	 this.passowrd = passowrd;
	}
		
	public Integer getAge() {
        return age;
    }

	public void setAge(Integer age) {
    	 this.age = age;
	}
	}