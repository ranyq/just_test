<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/js/bookdetail.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<span>书名:</span><div>${book.getBookName()}</div>

<button onclick="addToCart(${book.getBookId()},'${book.getBookName()}')">收藏</button>
<img src="/upload/image/1.jpg"/>

<a href="/books/download?bookId=${book.getBookId()}"><button >下载</button></a>
<a href="/evaulations/toAdd?bookId=${book.getBookId()}&&bookName=${book.getBookName()}"><button>评价</button></a>

</body>
</html>