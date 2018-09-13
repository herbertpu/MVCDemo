package com.login.service;

import com.login.domain.User;
import com.login.exception.UserExistException;

/**
 * 业务处理层
 * 存放处理系统业务接口类
 */
public interface IUserService {

    /**
     * 提供注册服务
     * @param user
     */
    void registerUser(User user) throws UserExistException;

    /**
     * 提供登陆服务
     * @param userName
     * @param userPwd
     * @return User
     */
    User loginUser(String userName, String userPwd);
}
