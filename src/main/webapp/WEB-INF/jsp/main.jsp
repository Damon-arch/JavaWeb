<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <title>主页面</title>
    <style>
        h3 {
            color: red;
        }
        .myTable {
            background: pink;
            table-layout: fixed;
            width: 100%;
        }
        .tableHead {
            background: skyblue;
        }
    </style>
</head>
<body>
<h3>欢迎您，<%=request.getSession().getAttribute("username")%></h3>
<button class="btn btn-primary">呵呵</button>
<table class="myTable">
    <tr class="tableHead">
        <td>id</td>
        <td>书名</td>
        <td>作者</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.get('bookList')}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.author}</td>
            <td>
                <button type="button" class="btn btn-primary">修改</button>
                <button class="btn btn-danger">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
</body>
</html>
