<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<form action="/evaulations/add" method="post">
    <label><input type="radio" name="level" value="1"/>一星</label>
    <label><input type="radio" name="level" value="2"/>二星</label>
    <label><input type="radio" name="level" value="3"/>三星</label>
    <label><input type="radio" name="level" value="4"/>四星</label>
    <label><input type="radio" name="level" value="5"/>五星</label>
    <input type="text" name="evaluate" />
    <input type="hidden" name="bookid" value="${bookId}"/>
    <input type="hidden" name="bookName" value="${bookName}"/>
    <input type="submit"/>
</form>
</body>
</html>
