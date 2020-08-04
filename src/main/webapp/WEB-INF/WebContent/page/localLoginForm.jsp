<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: BloodFly
  Date: 2020/7/16
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>测试基于浏览器请求Accept-language请求头的国际化</title>
</head>
<body>
<!--使用Message标签输出国际化信息-->
<h3><spring:message code="title"/></h3>
<jsp:useBean id="user" class="com.stte.smvc.entity.User" scope="request"/>
<form:form modelAttribute="user" method="post" action="/local/login">
    <table>
        <tr>
            <td>
                <spring:message code="loginname"/>
                <form:input path="loginname"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="password"/>
                <form:input path="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="<spring:message code="submit"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
