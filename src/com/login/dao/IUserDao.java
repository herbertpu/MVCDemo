package com.login.dao;

import com.login.domain.User;

/**
 * 数据访问层
 * 存放访问数据库的操作接口类
 *
 * Dao层直接和数据库交互
 * CRUD(增删改查)操作
 */
public interface IUserDao {

    /**
     * 根据用户名和密码来查找用户
     * @param userName
     * @param userPwd
     * @return User
     */
    User find(String userName, String userPwd);

    /**
     * 根据用户名来查找用户
     * @param userName
     * @return User
     */
    User find(String userName);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);
}