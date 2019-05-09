<%@ page import="java.util.List" %>
<%@ page import="com.bookHouse.domain.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% List<Category> allcategorylist =(List<Category>) request.getAttribute("ALL_CATEGORY"); %>
<% List<Category> parentcategorylist =(List<Category>) request.getAttribute("PARENT_CATEGORY"); %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/js/category_manager.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<button onclick="showParentCategory()">增加一级分类</button>
<button onclick="showChildCategory()">添加二级分类</button>
<div id="inputParent" hidden>
    <form action="/categorys/add">
    <input type="text" name="categoryName"id="parentName"/>
    <input type="submit" value="提交">
    </form>
</div>
<div id="inputChild" hidden>
    <form action="/categorys/add">
     <select id="parentSelect" name="parentId">
         <% for(Category item:parentcategorylist){%>
         <option value="<%=item.getId()%>" ><%=item.getCategoryName()%></option>
         <%}%>
     </select>
    <input type="text" id="childName" name="categoryName"/>
    </form>
</div>
<ul id="categoryShow">
    <% for(Category parentcategory:parentcategorylist){%>
    <li><%=parentcategory.getCategoryName()%></li>
    <a href="/categorys/delete?id=<%=parentcategory.getId()%>">删除</a>
    <% for(Category childcategory:allcategorylist){
    if(childcategory.getParentId()==parentcategory.getId()&&childcategory.getLevel()==2){%>
    <li><%=childcategory.getCategoryName()%></li>
    <a href="/categorys/delete?id=<%=childcategory.getId()%>">删除</a>
    <%}
    }%>
    <%}%>
</ul>
</body>
</html>