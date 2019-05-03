<%@ page import="java.util.List" %>
<%@ page import="com.bookHouse.domain.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<Category> allcategorylist =(List<Category>) request.getAttribute("ALL_CATEGORY"); %>
<% List<Category> parentcategorylist =(List<Category>) request.getAttribute("PARENT_CATEGORY"); %>
<head>
    <title></title>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<button value="增加分类">增加分类</button>
<ul>
    <% for(Category parentcategory:parentcategorylist){%>
    <li><%=parentcategory.getCategoryName()%></li>
    <button value=""></button>
    <%}%>
</ul>
</form>
</body>
</html>