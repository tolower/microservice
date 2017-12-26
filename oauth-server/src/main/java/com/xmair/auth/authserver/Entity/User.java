package com.xmair.auth.authserver.Entity;


/**
 * Created by Song on 2017/2/15.
 * Model 用户
 */

public class User {
    private long id;

    private String name;

    private String password;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private  Integer age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
