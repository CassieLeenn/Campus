<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/6/30
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>公告发布</title>
    <script src="jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./Style.css"/>
    <style>
        html, body {
            background-color: #f0f2fa;
            font-family: "PT Sans", "Helvetica Neue", "Helvetica", "Roboto", "Arial", sans-serif;
            color: #555f77;
            -webkit-font-smoothing: antialiased;
        }
        .nav {
            height: 41px;
            border-top: 3px solid #ff8500;
            border-bottom: 1px solid #edeef0;
            background-color: #fff;
            line-height: 41px;
        }

        .nav a {
            /*   此时的a为行内元素 修改高无效 需要将a转换为行内块元素 它既可以有宽度 又可以有高度*/
            display: inline-block;
            height: 41px;
            padding: 0 20px;
            /* 上下为0  左右为20px */
            font-size: 12px;
            color: #4c4ac4;
            text-decoration: none;
        }

        .nav a:hover {
            background-color: #eee;
            color: #ff8500;
        }
    </style>
</head>
<body>
<div class="nav">
    <a href="addInformation.jsp">增添景点</a>
    <a href="addPath.jsp">添加路径</a>
    <a href="stuPicture.jsp">地图查看</a>
</div>
<form action="warm" method="post">
    <div class="container" style="height: 350px;">
        <div class="login-box">
            <div class="apple-btn">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <div class="title">发布公告</div>
            <div style="position:absolute;top:25px;left: 425px;">
                <div style="color: #eeeeee">${error1}</div>
            </div>
            <div class="input">
                <input id="Warm" type="text" value="${information}" placeholder="请输入公告内容"/>
            </div>

            <button class="btn login-btn" onclick="ok()" type="button">
                <span>确认</span>
            </button>
        </div>
    </div>
</form>
<script type="text/javascript" src="./Script.js"></script>
<script>
        function ok() {
            var warming=document.getElementById("Warm").value;
            $.ajax({
                url:"warm",
                type:"post",
                traditional:true,
                datatype:"json",
                async:false,
                data:{
                    "warming":warming
                },
            });
            alert("发布公告成功！")
        }
    </script>

</body>
</html>
