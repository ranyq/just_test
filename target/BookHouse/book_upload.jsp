<%@ page import="com.bookHouse.domain.Category" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<% List<Category> allcategorylist =(List<Category>) request.getAttribute("ALL_CATEGORY"); %>--%>
<%--<% List<Category> parentcategorylist =(List<Category>) request.getAttribute("PARENT_CATEGORY"); %>--%>
<html>
<head>
    <title></title>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <%--<script type="text/javascript">--%>
        <%--selectParent=function(){--%>
            <%--var alllist='<%=allcategorylist%>';--%>
            <%--$("#childSelect").val(null);--%>
            <%--var parentid=$("#parentSelect").val();--%>
            <%--for(var i=0;i<=alllist.length;i++){--%>
                <%--if(alllist[i].getId()==parentid){--%>
                    <%--var childoption="<option value='"+alllist[i].getId()+"'>"+alllist[i].getCategoryName()+"</option>"--%>
                    <%--$("#childSelect").append()--%>
                <%--}--%>

            <%--}--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<form  action="${pageContext.request.contextPath}/books/upload" method="post" enctype="multipart/form-data">
    <span>书名:</span><input type="text" id="bookName" name="bookName"/>
    <span>作者:</span><input type="text" id="bookAuthor" name="author"/>
    <span>国家:</span><input type="text" id="" name="nation"/>
    <span>简介:</span><input type="text" id="brief" name="bookBrief"/>
    <span>分类</span> <select id="parentSelect" onchange="selectParent()">
    <%--<% for(Category item:parentcategorylist){%>--%>
    <%--<option value="<%=item.getId()%>"><%=item.getCategoryName()%></option>--%>
    <%--<%}%>--%>
        <select id="childSelect">
</select>
    <span>封面:</span><input type="file" id="cover" name="cover">
    <span>电子书</span><input type="file" id="bookText" name="bookText">
    <input type="submit"/>
    <div>${err_msg}</div>
</form>
</body>
</html>