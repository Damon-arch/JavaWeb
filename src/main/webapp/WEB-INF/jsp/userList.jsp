<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户列表展示</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/app/toAddUser">
    <button class="btn btn-success">新增</button>
</a>
<table>
    <tr>
        <td>id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.get('userList')}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.password}</td>
            <td>
                <a href="${pageContext.request.contextPath}/app/toUpdateUser?userId=${item.id}">
                    <button type="button" class="btn btn-primary btn-sm">修改</button>
                </a>
                <a href="${pageContext.request.contextPath}/app/deleteUser?userId=${item.id}">
                    <button class="btn btn-danger btn-sm">删除</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
