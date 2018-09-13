package com.login.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.domain.User;
import com.login.exception.UserExistException;
import com.login.service.IUserService;
import com.login.service.impl.UserServiceImpl;
import com.login.util.WebUtils;
import com.login.web.formbean.RegisterFormBean;

import java.io.IOException;

/**
 * RegisterServlet担任着以下几个职责：
 * 1、接收客户端提交到服务端的表单数据
 * 2、校验表单数据的合法性，如果校验失败跳回到register.jsp，并回显错误信息
 * 3、如果校验通过，调用service层向数据库中注册用户
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将客户端提交的表单数据封装到RegisterFormBean对象中
        RegisterFormBean formBean = WebUtils.requestBean(request, RegisterFormBean.class);
        //校验用户注册填写的表单数据
        if (formBean.validate() == false) {//校验失败
            //将封装了用户填写的表单数据的formBean对象发送回register.jsp页面的form表单中进行显示
            request.setAttribute("formBean", formBean);
            //跳转回register.jsp
            request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
            return ;
        }

        User user = new User();
        try {
            //ConvertUtils.register(new DateLocaleConverter(), Date.class);//注册字符串到日期的转换器
            //BeanUtils.copyProperties(user, formBean);//把表单的数据填充到javaBean中
            WebUtils.copyBean(formBean, user);
            user.setId(WebUtils.makeId());//设置用户的Id属性
            IUserService service = new UserServiceImpl();
            service.registerUser(user);//调用service层提供的注册用户服务实现用户注册
            String message = String.format("注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", request.getContextPath() + "/LoginUIServlet");
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (UserExistException e) {
            formBean.getErrors().put("userName", "注册用户已存在！！");
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();//在后台记录异常
            request.setAttribute("message", "对不起，注册失败！！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }
}
