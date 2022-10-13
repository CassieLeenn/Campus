<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/7/6
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告</title>
</head>
<script>
    var notice='<%=session.getAttribute("notice")%>';
    console.log(notice);
    alert(notice);
    window.location.href = "informationSearch.jsp";
</script>
<body>

</body>
</html>
