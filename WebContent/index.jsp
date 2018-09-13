<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
<h2>Hello World!</h2><br/>

<div style="text-align: right;">
    <c:if test="${user != null }">
        欢迎您：${user.userName }
        <a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
    </c:if>

    <c:if test="${user == null }">
        <a href="${pageContext.request.contextPath }/RegisterUIServlet">注册</a>
        <a href="${pageContext.request.contextPath }/LoginUIServlet">登录</a>
    </c:if>
</div>
<hr/>
</body>
</html>
