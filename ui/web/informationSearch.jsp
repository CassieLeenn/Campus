<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/6/29
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>景点信息查询</title>
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
            width: 380px;
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
        p {
            line-height: 1.3125rem;
        }
        .comments {
            margin: 2.5rem auto 0;
            max-width: 60.75rem;
            padding: 0 1.25rem;
        }
        .comment-wrap {
            margin-bottom: 1.25rem;
            display: table;
            width: 100%;
            min-height: 5.3125rem;
        }
        .photo {
            padding-top: 0.625rem;
            display: table-cell;
            width: 4.0rem;
        }
        .photo .avatar {
            height: 2.25rem;
            width: 2.25rem;
            border-radius: 50%;
            background-size: contain;
        }
        .comment-block {
            padding: 1rem;
            background-color: #fff;
            display: table-cell;
            vertical-align: top;
            border-radius: 0.1875rem;
            box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.08);
        }
        .comment-block textarea {
            width: 100%;
            max-width: 100%;
        }
        .comment-text {
            margin-bottom: 1.25rem;
        }
        .comment-actions li {
            display: inline;
        }
        .comment-actions li.complain {
            padding-right: 0.625rem;
            border-right: 1px solid #e1e5eb;
        }
        .comment-actions li.reply {
            padding-left: 0.625rem;
        }
    </style>
</head>
<body>
<div class="nav">
    <a href="shortPath.jsp">路径查询</a>
    <a href="orderPath.jsp">按序路径查询</a>
    <a href="comment.jsp">景点评论</a>
    <a href="studentInformation.jsp">个人信息</a>
    <a href="stuPicture.jsp">地图查看</a>
</div>
<div class="comments">
    <div class="comment-wrap">
        <div class="comment-block">
            <p class="comment-text">不知道去哪？点开推荐看一看吧！</p>
        </div>
    </div>
</div>
<form action="searchPlace" method="get">
<div id="box">
    <input type="search" name="search" placeholder="请输入景点名称" value="${place}">
    <button id="search" type="submit">搜索</button>
</div>
</form>
<form action="show_recommend" method="get">
    <button id="search1" type="submit" style="position: absolute;left:800px;top:207px;">景点推荐</button>
</form>
    <div style="position:absolute;top:250px;left: 425px;width: 400px">
        <p>${information}</p>
    </div>


</body>
</html>
