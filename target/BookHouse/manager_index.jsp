<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div><a href="${pageContext.request.contextPath}/manage/manageuser?page=1&&pageSize=20">用户管理</a></div>
<div ><a href="${pageContext.request.contextPath}/manage/managebook?page=1&&pageSize=20">电子书管理</a></div>
<div><a href="${pageContext.request.contextPath}/manage/managecategory">分类管理</a></div>
</body>
</html>