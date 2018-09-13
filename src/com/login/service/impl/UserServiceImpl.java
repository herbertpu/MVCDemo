package com.login.service.impl;

import com.login.dao.IUserDao;
import com.login.dao.impl.UserDaoImpl;
import com.login.domain.User;
import com.login.exception.UserExistException;
import com.login.service.IUserService;

/**
 * 业务处理层
 * 存放处理系统业务接口的实现类
 */
public class UserServiceImpl implements IUserService {

    private IUserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) throws UserExistException {
        if (userDao.find(user.getUserName()) != null){
            throw new UserExistException("注册的用户名已存在！！！");
        }
        userDao.add(user);
    }

    @Override
    public User loginUser(String userName, String userPwd) {
        return userDao.find(userName, userPwd);
    }
}
