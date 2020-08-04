<%--
  Created by IntelliJ IDEA.
  User: BloodFly
  Date: 2020/7/8
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterForm</title>
</head>
<body>
<form id="registerForm" action="/user/register" method="post">
    <table>
        <tr>
            <td>登陆名：</td>
            <td><input type="text" id="loginname" name="loginname"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="password" name="password"/></td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td><input type="text" id="username" name="username"/></td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><input type="text" id="birthday" name="birthday"/></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="注册"/></td>
        </tr>
    </table>
</form>
</body>
</html>
