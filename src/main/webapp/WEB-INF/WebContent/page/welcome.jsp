<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: BloodFly
  Date: 2020/7/8
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!!</title>
</head>
<body>
<h3>欢迎您！【${requestScope.user.username}】登陆</h3>
<h4>从request作用域拿取user对象：${requestScope.user}</h4>
<h4>从session作用域拿取user对象：${sessionScope.user}</h4>
<h4>生日：<fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日"/></h4>

<%--如果希望在视图页面将模型属性数据 以格式化的方式进行渲染，则需要使用Spring的页面标签显示数据模型--%>
<form:form modelAttribute="user">
    <table>
        <tr>
            <td>日期类型：</td>
            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td>整数类型：</td>
            <td><form:input path="total"/></td>
        </tr>
        <tr>
            <td>百分数：</td>
            <td><form:input path="discount"/></td>
        </tr>
        <tr>
            <td>货币类型：</td>
            <td><form:input path="money"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
