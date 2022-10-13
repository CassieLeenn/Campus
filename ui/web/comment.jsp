<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/6/29
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>景点评论</title>
    <script src="jquery-3.6.0.min.js"></script>
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

        #box{
            width: 600px;
            margin: 30px auto;
            font-family: 'Microsoft YaHei';
            font-size: 14px;
        }

        input{
            width: 260px;
            border: 1px solid #e2e2e2;
            height: 30px;
            float: left;
            background-repeat: no-repeat;
            background-size: 25px;
            background-position:5px center;
            padding:0 0 0 40px;
        }

        #search{
            width: 78px;
            height: 32px;
            left: 550px;
            top: 300px;
            background: #fcd079;
            color: #ffffff;
            text-align: center;
            line-height: 32px;
            cursor: pointer;
            border-style:none ;
            border-radius: 25px;
        }

        #search:hover{
            background: #e8e08c;
        }

        #search1{
            width: 78px;
            height: 32px;
            background: #fcd079;
            color: #ffffff;
            text-align: center;
            line-height: 32px;
            cursor: pointer;
            border-style:none ;
            border-radius: 25px;
        }

        #box1{
            width: 600px;
            margin: 50px auto;
            font-family: 'Microsoft YaHei';
            font-size: 14px;
        }

        #search1:hover{
            background: #e8e08c;
        }
    </style>
</head>
<body>
<div class="nav">
    <a href="shortPath.jsp">路径查询</a>
    <a href="orderPath.jsp">按序路径查询</a>
    <a href="informationSearch.jsp">景点信息查询</a>
    <a href="studentInformation.jsp">个人信息</a>
    <a href="stuPicture.jsp">地图查看</a>
</div>
<form action="remark" method="get">
    <div id="box" style="position:absolute;left: 350px;">
        <input  name="place" placeholder="请输入景点名称"><button id="search" type="submit">确认</button>
        <textarea rows="15" cols="90" value="请输入评论内容" name="comment" placeholder="请输入评论内容" value="${comment}" style="position:absolute;top:80px;left: 0px;"></textarea>
        <div><p>${Tips}</p></div>
    </div>
</form>
<div id="box1" style="position:absolute;top:380px;left: 350px;">
    <form action="showremark" method="get">
        <input  name="place" placeholder="请输入查看评论的景点名称"><button id="search1" type="submit">搜索评论</button>
    </form>
</div>
</body>
</html>
