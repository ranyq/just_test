<%@ page import="java.util.List" %>
<%@ page import="com.bookHouse.domain.Book" %>
<%@ page import="com.bookHouse.domain.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%List<Book> bookListTime=(List<Book>) request.getAttribute("bookLisTime");%>
<%List<Book> bookListDown=(List<Book>) request.getAttribute("bookListDown");%>
<%List<Category> allCategory=(List<Category>) request.getAttribute("allCategory");%>
<html>
<head>
    <title>
    </title>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="/js/index.js"></script>
</head>
<body>
<div>
<form action="/books/searchByKeyword?page=1&&pageSize=10" method="post">
    <input type="text" id="keyword" name="keyword"/>
    <input type="submit" value="搜索"/>
</form>
</div>
<div>
    <%if((request.getSession().getAttribute("userId"))!=null&& !(request.getSession().getAttribute("userId")).equals("")){%>
    <a href="/user/toMySpace">
        <%=request.getSession().getAttribute("userId")%>
    </a>
    <a href="/user/logout">
        退出
    </a>
    <%}else{%>
    <a href="/login.jsp">
        登录
    </a>
    <a href="/register.jsp">
        注册
    </a>
    <%}%>
</div>
<div>
    <ul>
    <%for(Category category:allCategory){
    if(category.getLevel()==1){%>
        <a href="/books/searchByCategory?page=1&&pageSize=10&&categoryId=<%=category.getId()%>">
        <li>
            <%=category.getCategoryName()%>
        </li>
        </a>
    <%}}%>
    </ul>
</div>
<div >
    <table>
        <tr>
    <%for(Book booktime:bookListTime){%>
    <a href="/books/detail?id=<%=booktime.getBookId()%>">
        <td>
        <%=booktime.getBookName()%>
    </td>
    </a>
    <%}%>
        </tr>
    </table>
</div>
<div>
    <table>
        <tr>
        <%for(Book bookdown:bookListDown){%>
            <a href="/books/detail?id=<%=bookdown.getBookId()%>">
        <td>
            <%=bookdown.getBookName()%>
        </td>
                </a>
        <%}%>
        </tr>
    </table>
</div>
</body>
</html>
