<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/js/bookdetail.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<span>用户名:</span>${user.getName()}
<span>电话:</span>${user.getEmail()}
<span>邮箱:</span>${user.getPhone()}
<span>创建时间:</span>${user.getCreateTime()}
</body>
</html>