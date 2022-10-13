<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/6/28
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.util.*" %>
<html>
  <head>
    <title>校园导航</title>
    <script src="jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./Style.css"/>
  </head>
  <body background-color="white">
  <form action="Servlet" method="post" id="form">
  <div class="container" style="height: 350px;">
    <div class="login-box">
      <div class="apple-btn">
        <li class="red-btn"></li>
        <li class="yellow-btn"></li>
        <li class="green-btn"></li>
      </div>
      <div class="title">Login</div>
      <div style="position:absolute;top:25px;left: 425px;">
        <select name="UserorAdmin" class="choose">
          <option value="user">用户端</option>
          <option value="admin">管理端</option>
        </select>
        <div style="color: #eeeeee">${error}</div>

      </div>
      <div class="input">
        <input name="username" id="name" type="text" value="${username}" placeholder="Input your username"/>
      </div>
      <div class="input">
        <input name="password" id="pass" type="password" placeholder="Input your password"/>
      </div>
      <button class="btn login-btn" onclick="check()">
        <span>登录</span>
      </button>
      <div class="change-box login-change">
        <div class="change-btn tobegin" onclick="window.location.href='register.jsp';">
          <span>去注册</span>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="./Script.js">
    function check() {
      var user=document.getElementById("name").value;
      var pass=document.getElementById("pass").value;
      if(user==null){
        alert("用户名不能为空！");
        return;
      }
      if (pass==null){
        alert("密码不能为空！");
        return;
      }
      document.getElementById(form).submit;
    }
  </script>
  </form>
  </body>
</html>
