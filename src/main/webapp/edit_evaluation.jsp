<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <script>
        initLevel=function(){
            for()
        }
    </script>
</head>
<body>
<form action="/evaulations/edit" method="post">
    <label><input type="radio" name="level" value="1"/>一星</label>
    <label><input type="radio" name="level" value="2"/>二星</label>
    <label><input type="radio" name="level" value="3"/>三星</label>
    <label><input type="radio" name="level" value="4"/>四星</label>
    <label><input type="radio" name="level" value="5"/>五星</label>
    <input type="text" name="evaluate" value="${eva.getEvaluation()}"/>
    <input type="hidden" name="bookid" value="${eva.getBookid()}"/>
    <input type="hidden" name="bookName" value="${eva.getBookName()}"/>
    <input type="hidden" name="bookName" value="${eva.getBookName()}"/>
    <input type="hidden" name="id" value="${eva.getId()}"/>
    <input type="submit"/>
</form>
</body>
</html>
