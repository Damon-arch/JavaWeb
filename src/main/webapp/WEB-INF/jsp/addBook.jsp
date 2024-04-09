<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>增加书籍</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addBook" method="post">
    书名：<input type="text" name="name"> <br>
    作者：<input type="text" name="author"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
