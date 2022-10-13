<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/6/29
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加路径</title>
    <script src="jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./Style.css"/>
    <style>
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
    <a href="addNotice.jsp">发布公告</a>
    <a href="stuPicture.jsp">地图查看</a>
</div>
<form action="addPath" method="get">
    <div class="container" style="height: 450px;">
        <div class="login-box">
            <div class="apple-btn">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <div class="title">添加路径</div>
            <div style="position:absolute;top:25px;left: 425px;">
            <div style="color: #eeeeee">${tips}</div>
            </div>
            <div class="input">
                <input name="start" type="text" placeholder="请输入路径起点"/>
            </div>
            <div class="input">
                <input name="end" type="text" placeholder="请输入路径终点"/>
            </div>
            <div class="input">
                <input name="length" type="text" placeholder="请输入路径长度"/>
            </div>
            <button class="btn login-btn" type="submit">
                <span>确认</span>
            </button>
        </div>
    </div>
    <script type="text/javascript" src="./Script.js">
    </script>
</form>
</body>
</html>
