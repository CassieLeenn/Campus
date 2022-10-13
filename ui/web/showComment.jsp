<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/7/5
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论展示</title>
    <style>
        html,
        body {
            background-color: #f0f2fa;
            font-family: "PT Sans", "Helvetica Neue", "Helvetica", "Roboto", "Arial", sans-serif;
            color: #555f77;
            -webkit-font-smoothing: antialiased;
        }
        input,
        textarea {
            outline: none;
            border: none;
            display: block;
            margin: 0;
            padding: 0;
            -webkit-font-smoothing: antialiased;
            font-family: "PT Sans", "Helvetica Neue", "Helvetica", "Roboto", "Arial", sans-serif;
            font-size: 1rem;
            color: #555f77;
        }
        input::-webkit-input-placeholder,
        textarea::-webkit-input-placeholder {
            color: #ced2db;
        }
        input::-moz-placeholder,
        input:-moz-placeholder,
        textarea:-moz-placeholder {
            color: #ced2db;
        }
        input:-ms-input-placeholder,
        textarea:-ms-input-placeholder {
            color: #ced2db;
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
        .bottom-comment {
            color: #acb4c2;
            font-size: 0.875rem;
        }
        .comment-date {
            float: left;
        }
        .comment-actions {
            float: right;
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
<c:forEach items="${comment_nickname}" var="nick" varStatus="loop">
<div class="comments">
    <div class="comment-wrap">
        <div class="photo">
            <div class="avatar">${comment_nickname[loop.count-1]}</div>
        </div>
        <div class="comment-block">
            <p class="comment-text">${comment_comment[loop.count-1]}</p>
            <div class="bottom-comment">
                <div class="comment-date">${comment_time[loop.count-1]} ${place}</div>
            </div>
        </div>
    </div>

</div>
</c:forEach>
</body>
</html>
