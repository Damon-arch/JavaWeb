<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<p style="text-align: center">请登录</p>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="username">
        用户名：<input id="username" name="username" type="text" required>
    </label>
    <br>
    <label for="password">
        密码：<input id="password" name="password" type="password" required>
    </label>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>