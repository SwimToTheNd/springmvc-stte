<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<jsp:useBean id="user" class="com.stte.smvc.entity.User" scope="request"/>
<form:form modelAttribute="user" id="registerForm2" action="/user/register2" method="post">
    <table>
        <tr>
            <td>登陆名：</td>
            <td><form:input path="loginname"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="注册"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
