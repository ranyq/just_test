<%@ page import="com.bookHouse.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<Book> booklist=(List<Book>)request.getAttribute("result");%>
<html>
<body>

<form action="/books/searchByKeyword" method="post">
    <input type="hidden" name="page" value="1" >
    <input type="hidden" name="pageSize" value="2" >
    <input type="text" id="keyword" name="keyword"/>
    <input type="submit" value="搜索"/>
</form >
<%for(Book one:booklist){%>
<img src="<%=one.getCoverAddress()%>"/>

<%}%>

<%%>
<a href="/books/searchByKeyword?page=${page}-1&&pageSize=10&&keyword=${keyword}">pre</a>
<a href="/books/searchByKeyword?page=${page}+1&&pageSize=10&&keyword=${keyword}">start</a>
</body>
</html>
