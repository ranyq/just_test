<%@ page import="com.bookHouse.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<Book> booklist=(List<Book>)request.getAttribute("booklist");%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/js/bookdetail.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<div id="myCollection">
    <table>
        <tr>
            <%for(Book book:booklist){%>
            <td><img src=""/>
                <%=book.getBookName()%>
                <%=book.getAuthor()%>
                <a href="/collection/cancel?bookId=<%=book.getBookId()%>>">取消收藏</a>
            </td>
            <%}%>
        </tr>
    </table>
</div>
</body>
</html>