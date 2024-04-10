<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>更新用户</title>
</head>
<body>
<p>请修改用户</p>
<form action="${pageContext.request.contextPath}/app/updateUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    用户名称：<input type="text" name="name" value="${user.name}"> <br>
    用户密码：<input type="text" name="password" value="${user.password}"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
