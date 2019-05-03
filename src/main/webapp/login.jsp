<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<form  action="${pageContext.request.contextPath}/user/login" method="post" onsubmit="return checkInfo()">
    <span>用户名:</span><input type="text" id="name" name="name"/>
    <span>密码:</span><input type="password" id="password" name="password"/>
    <input type="submit"/>
    <div>${err_msg}</div>
</form>
</body>
</html>