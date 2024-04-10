<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/app/addUser" method="post">
    用户名：<input type="text" name="name"> <br>
    密码：<input type="text" name="password"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
