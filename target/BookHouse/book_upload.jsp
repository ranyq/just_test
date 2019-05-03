<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<form  action="${pageContext.request.contextPath}/books/upload" method="post" enctype="multipart/form-data">
    <span>书名:</span><input type="text" id="bookName" name="bookName"/>
    <span>作者:</span><input type="text" id="bookAuthor" name="author"/>
    <span>国家:</span><input type="text" id="" name="nation"/>
    <span>简介:</span><input type="text" id="brief" name="bookBrief"/>
    <span>封面:</span><input type="file" id="cover" name="cover">
    <span>电子书</span><input type="file" id="bookText" name="bookText">
    <input type="submit"/>
    <div>${err_msg}</div>
</form>
</body>
</html>