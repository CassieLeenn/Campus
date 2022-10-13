<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看路径</title>
    <link rel="stylesheet" type="text/css" href="./Style.css"/>
</head>
<body>
<div class="container" style="height: 350px;">
    <div class="login-box">
        <div class="apple-btn">
            <li class="red-btn"></li>
            <li class="yellow-btn"></li>
            <li class="green-btn"></li>
        </div>
        <div class="title" id="way"></div>
        <div style="width: 80%;height: 80%;padding:10%">
        <p id="count" style="color: #eeeeee"></p>
        <p id="path" style="color: #eeeeee"></p>
        <p id="length" style="color: #eeeeee"></p>
        <p id="show" style="color: #eeeeee"></p>
        </div>
    </div>
</div>
<div>
</div>
<!--
<div style="width: 1200px;height: 800px;"><img id="image"  width="1200px"/></div>
-->
</body>
</html>
<script>
    window.onload=function () {
        var a=new Array();
        var his='';
        var length="共行走："+'<%=session.getAttribute("length")%>'+"米";
        var count="共经过"+'<%=session.getAttribute("count")%>'+"个景点";
        var way='<%=session.getAttribute("way")%>';
        var path="行走路径："+'<%=session.getAttribute("path")%>';
        var _way=document.getElementById("way");
        _way.innerHTML=way;
        var _count=document.getElementById("count");
        _count.innerHTML=count;
        var _path=document.getElementById("path");
        _path.innerHTML=path;
        var _length=document.getElementById("length");
        _length.innerHTML=length;
        var name='<%=session.getAttribute("name")%>';
        var tips="路径图片已保存在桌面："+name+".jpg";
        var _show=document.getElementById("show");
        _show.innerHTML=tips;
        //var _image=document.getElementById("image");
        //_image.src=name+".jpg";
    }


</script>
</body>
</html>
