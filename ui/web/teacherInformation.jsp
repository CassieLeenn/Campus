<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/7/7
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教职工信息录入</title>
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
    <a href="shortPath.jsp">路径查询</a>
    <a href="orderPath.jsp">按序路径查询</a>
    <a href="comment.jsp">景点评论</a>
    <a href="informationSearch.jsp">景点信息查询</a>
    <a href="stuPicture.jsp">地图查看</a>
</div>
<form action="personal_b" method="get" id="form">
    <div class="container" style="height: 500px;">
        <div class="login-box">
            <div class="apple-btn">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <div class="title">教职工信息</div>
            <div style="position:absolute;top:25px;left: 425px;">
                <div style="color: #eeeeee">${error}</div>
            </div>
            <div class="input">
                <input name="Fno" type="text" placeholder="请输入学号"/>
            </div>
            <div class="input">
                <input name="Fname" type="test" placeholder="请输入姓名"/>
            </div>
            <div class="input">
                <input name="Fjob" type="text" placeholder="请输入专业"/>
            </div>
            <div class="input">
                <input name="Fdept" type="text" placeholder="请输入学院"/>
            </div>
            <button class="btn login-btn" type="submit">
                <span>提交</span>
            </button>
            <div class="change-box login-change">
                <div class="change-btn tobegin" onclick="window.location.href='studentInformation.jsp';">
                    <span>我是学生</span>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
