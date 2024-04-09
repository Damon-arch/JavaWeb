<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>更新书籍</title>
</head>
<body>
<p>请修改书籍</p>
<form action="${pageContext.request.contextPath}/updateBook" method="post">
    <input type="hidden" name="id" value="${book.id}">
    书籍名称：<input type="text" name="name" value="${book.name}"> <br>
    书籍作者：<input type="text" name="author" value="${book.author}"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
