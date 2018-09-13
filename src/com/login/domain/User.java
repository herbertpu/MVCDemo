package com.login.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * domain(域模型)层
 * 存放系统的JavaBean类(只包含简单的属性以及属性对应的get和set方法，不包含具体的业务处理方法)，提供给【数据访问层】、【业务处理层】、【Web层】来使用
 */
public class User implements Serializable {
    private String id;
    private String userName;
    private String userPwd;
    private String email;
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
