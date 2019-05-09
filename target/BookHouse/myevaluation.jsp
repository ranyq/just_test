<%@ page import="com.bookHouse.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bookHouse.domain.Evaluation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<Evaluation> evalist=(List<Evaluation>)request.getAttribute("evalist");%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/js/bookdetail.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<div id="myEvaluation">
    <table>
        <tr>
            <%for(Evaluation eva:evalist){%>
            <td>
                <%=eva.getLevel()%>
                <%=eva.getEvaluate()%>
                <a href="/evaluation/toEdit?id=<%=eva.getId()%>">编辑</a>
                <a href="/evaluation/delete?id=<%=eva.getId()%>">删除</a>
            </td>
            <%}%>
        </tr>
    </table>
</div>
</body>
</html>