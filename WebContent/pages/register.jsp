<%--
  Created by IntelliJ IDEA.
  User: gxyan
  Date: 2018/6/5
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body style="text-align: center;">
    <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
        <table width="60%" border="1">
            <tr>
                <td>用户名</td>
                <td>
                    <input type="text" name="userName" value="${formBean.userName}">${formBean.errors.userName}
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="password" name="userPwd" value="${formBean.userPwd}">${formBean.errors.userPwd}
                </td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td>
                    <input type="password" name="confirmPwd" value="${formBean.confirmPwd}">${formBean.errors.confirmPwd}
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td>
                    <input type="text" name="email" value="${formBean.email}">${formBean.errors.email}
                </td>
            </tr>
            <tr>
                <td>生日</td>
                <td>
                    <input type="text" name="birthday" value="${formBean.birthday}">${formBean.errors.birthday}
                </td>
            </tr>
            <tr>
                <td>
                    <input type="reset" value="清空">
                </td>
                <td>
                    <input type="submit" value="注册">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
