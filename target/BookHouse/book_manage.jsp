<%@ page import="com.bookHouse.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bookHouse.domain.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<Book> booklist =(List<Book>) request.getAttribute("booklist"); %>

<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <td>
            书名
        </td>
        <td>
            作者
        </td>
        <td>
            出版社
        </td>
        <td>
            操作
        </td>
    </tr>
<%for(Book book:booklist){%>
<tr>
    <td>
        <%=book.getBookName()%>
    </td>
    <td>

    </td>
    <td>
        <a href="/manage/showbookdetail?bookId=<%=book.getBookId()%>" target="_blank">详情</a>
        <a href="/manage/deleteBook?bookId=<%=book.getBookId()%>">删除</a>
        <a href="/manage/toUpdateBookById?bookId=<%=book.getBookId()%>">修改</a>
    </td>
</tr>
<%}%>
</table>
</body>
</html>