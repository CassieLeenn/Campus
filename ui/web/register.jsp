<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/6/28
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script src="jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./Style.css"/>
</head>

<body>
<form action="Register" method="post" id="form">
    <div class="container" style="height: 450px;">
        <div class="login-box">
            <div class="apple-btn">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <div class="title">Register</div>
            <div style="position:absolute;top:25px;left: 425px;">
                <select name="UserorAdmin" class="choose">
                    <option value="user">用户端</option>
                    <option value="admin">管理端</option>
                </select>
                <div style="color: #eeeeee">${error}</div>
            </div>
            <div class="input">
                <input name="username" type="text" placeholder="Input your username"/>
            </div>
            <div class="input">
                <input name="password" type="password" placeholder="Input your password"/>
            </div>
            <div class="input">
                <input name="nickname" type="text" placeholder="Input your nickname"/>
            </div>
            <button class="btn login-btn" onclick="check()">
                <span>注册</span>
            </button>
            <div class="change-box login-change">
                <div class="change-btn tobegin" onclick="window.location.href='index.jsp';">
                    <span>去登录</span>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="./Script.js">
    </script>
    <script type="text/javascript" src="./Script.js">
        function check() {
            var user=document.getElementById("name").value;
            var pass=document.getElementById("pass").value;
            if(user==''){
                alert("用户名不能为空！");
                return;
            }
            if (pass==''){
                alert("密码不能为空！");
                return;
            }
            document.getElementById(form).submit;
        }
    </script>
</form>
</body>
</html>
