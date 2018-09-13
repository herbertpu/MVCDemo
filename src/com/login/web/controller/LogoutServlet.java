package com.login.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //移除存储在session中的user对象，实现注销功能
        request.getSession().removeAttribute("user");
        request.setAttribute("message", "注销成功，浏览器将在3秒后跳转，如果没有跳转，你就点...！！<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'>");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }
}
