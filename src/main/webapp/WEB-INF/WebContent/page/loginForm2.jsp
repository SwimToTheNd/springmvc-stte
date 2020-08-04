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
    <title>LoginForm</title>
</head>
<body>
<jsp:useBean id="user" class="com.stte.smvc.entity.User" scope="request"/>

<form:form modelAttribute="user" id="loginForm2" action="/validate/login" method="post">
    <table style="border: 1px royalblue">
        <tr style="border: 1px royalblue">
            <td>登陆名：</td>
            <td><form:input path="loginname"/></td>
            <!--显示loginname的错误消息-->
            <td><form:errors path="loginname" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><form:password path="password"/></td>
            <!--显示password的错误消息-->
            <td><form:errors path="password" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="登陆"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
