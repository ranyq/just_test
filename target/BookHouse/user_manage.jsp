<%@ page import="com.bookHouse.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<User> userlist =(List<User>) request.getAttribute("userlist"); %>

<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <td>
            用户名
        </td>
        <td>
            状态
        </td>
        <td>
            操作
        </td>
    </tr>
<%for(User user:userlist){%>
<tr>
    <td>
        <%=user.getName()%>
    </td>
    <td>
        <%if(user.getStatus().equals("1")){%>
        正常
        <%}%>
        <%if(user.getStatus().equals("2")){%>
        已删除
        <%}%>
    </td>
    <td>
        <a href="/user/showdetail?userId=<%=user.getId()%>">详情</a>
        <%if(user.getStatus().equals("1")){%>
        <a href="/manage/deleteUser?userId=<%=user.getId()%>">删除</a>
        <%}%>
        <%if(user.getStatus().equals("2")){%>
        <a href="/user/restore?userId=<%=user.getId()%>">复原</a>
        <%}%>
    </td>
</tr>
<%}%>
</table>
</body>
</html>