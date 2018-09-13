package com.login.web.UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Web层(表现层)
 * 存放为用户提供用户界面的servlet
 *
 * 为用户提供注册的用户界面的Servlet
 * RegisterUIServlet负责为用户输出注册界面
 * 当用户访问RegisterUIServlet时，就跳转到WEB-INF/pages目录下的register.jsp页面
 */
@WebServlet(name = "RegisterUIServlet", urlPatterns = "/RegisterUIServlet")
public class RegisterUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
    }
}
