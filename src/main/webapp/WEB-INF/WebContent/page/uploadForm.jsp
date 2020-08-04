<%--
  Created by IntelliJ IDEA.
  User: BloodFly
  Date: 2020/7/18
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<h2>上传文件</h2>
    <form method="post" action="/upload/file" enctype="multipart/form-data">
    <table border="1px">
        <tr>
            <td>文件描述：</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td>请选择文件：</td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="上传"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
