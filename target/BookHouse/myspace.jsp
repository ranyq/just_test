<%@ page import="com.bookHouse.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bookHouse.domain.Evaluation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<Book> booklist=(List<Book>)request.getAttribute("collectbooklist");%>
<% List<Evaluation> evaluationlist=(List<Evaluation>)request.getAttribute("collectbooklist");%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/js/bookdetail.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<div id="myInformation">
<span>用户名:</span>${user.getName()}
<span>电话:</span>${user.getEmail()}
<span>邮箱:</span>${user.getPhone()}
<span>创建时间:</span>${user.getCreateTime()}
    <a href="user/toedit">编辑</a>
</div>
<div id="myCollection">
    <a href="/book/ownCollection">more</a>
    <table>
        <tr>
            <%for(Book book:booklist){%>
            <td><img src=""/>
                <%=book.getBookName()%>
                <%=book.getAuthor()%>
            </td>
            <%}%>
        </tr>
    </table>
</div>
<div id="myEvaluation">
    <a href="/evaluation/ownEvaluation">more</a>
    <table>
        <tr>
            <%for(Evaluation eva:evaluationlist){%>
            <td><img src=""/>
                <%=eva.getLevel()%>
                <%=eva.getEvaluate()%>
            </td>
            <%}%>
        </tr>
    </table>
</div>
</body>
</html>