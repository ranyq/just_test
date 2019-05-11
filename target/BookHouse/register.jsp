<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
    <script type="text/javascript" src="/js/register.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<form  action="${pageContext.request.contextPath}/user/register" method="post" onsubmit="return checkInfo()">
    <span>用户名:</span><input type="text" id="name" name="name" onblur="checkUserName()"/><div id="checkresult"></div>
    <span>密码:</span><input type="password" id="password" name="password"/>
    <span>确认密码</span><input type="password" id="password2" name="password2"/>
    <span>邮箱:</span><input type="email" id="email" name="email"/>
    <span>电话:</span><input type="text" id="phone" name="phone"/>
    <input type="submit" id="submit"/>
</form>
</body>
</html>