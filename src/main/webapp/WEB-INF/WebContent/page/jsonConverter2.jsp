<%--
  Created by IntelliJ IDEA.
  User: BloodFly
  Date: 2020/7/13
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON HttpMessageConverter</title>
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            console.log("ready")
            testRequestBody();
        });

        function testRequestBody() {
            // 返回值:XMLHttpRequestjQuery.post(url, [data], [callback], [type])
            // url:发送请求地址。
            // data:待发送 Key/value 参数。
            // callback:发送成功时回调函数。
            // type:返回内容格式，xml, html, script, json, text, _default。
            $.post("${pageContext.request.contextPath}/json/testResponseBody", null, function (data) {
                console.log(data)
                // jQuery.each(object, [callback])
                // object:需要例遍的对象或数组。
                // callback:每个成员/元素执行的回调函数。
                $.each(JSON.parse(data), function () {
                    console.log(this)
                    var tr = $("<tr align='center'/>");
                    $("<td/>").html(this.id).appendTo(tr);
                    $("<td/>").html(this.name).appendTo(tr);
                    $("<td/>").html(this.author).appendTo(tr);
                    $("#booktable").append(tr);
                })
            })
        }
    </script>
</head>
<body>
<table id="booktable" border="1" style="border-collapse: collapse;">
    <tr align="center">
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
    </tr>
</table>
</body>
</html>
