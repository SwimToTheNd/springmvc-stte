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
            $.ajax("${pageContext.request.contextPath}/json/testRequestBody",
                {
                    dataType: "json",   //预期服务器返回类型
                    type: "post",   //请求方式GET或POST
                    contentType: "application/json", //发送信息至服务器时的内容编码格式
                    data: JSON.stringify({id: 1, name: "spring mvc企业应用实战"}),
                    async: true, // 请求是否异步
                    // 请求成功后的回调函数
                    success: function (data) {
                        console.log(data);
                        $("#id").html(data.id);
                        $("#name").html(data.name);
                        $("#author").html(data.author);

                    },
                    //请求失败后的回调函数
                    error: function () {
                        alert("数据发送失败");
                    }
                }
            );
        }
    </script>
</head>
<body>
编号：<span id="id"></span><br/>
书名：<span id="name"></span><br/>
作者：<span id="author"></span><br/>
<input type="submit" onclick="testRequestBody()" value="提"/>
</body>
</html>
