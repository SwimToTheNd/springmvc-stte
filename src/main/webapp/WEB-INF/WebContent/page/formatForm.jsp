<%--
  Created by IntelliJ IDEA.
  User: BloodFly
  Date: 2020/7/11
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/format/test" method="post">
    <table>
        <tr>
            <td><label>日期类型：</label></td>
            <td><input type="text" id="birthday" name="birthday"/></td>
        </tr>
        <tr>
            <td><label>整数类型：</label></td>
            <td><input type="text" id="total" name="total"/></td>
        </tr>
        <tr>
            <td><label>百分数类型：</label></td>
            <td><input type="text" id="discount" name="discount"/></td>
        </tr>
        <tr>
            <td><label>货币类型：</label></td>
            <td><input type="text" id="money" name="money"/></td>
        </tr>
        <tr>
            <input type="submit" id="submit" value="提交"/>
        </tr>
    </table>
</form>
</body>
</html>
