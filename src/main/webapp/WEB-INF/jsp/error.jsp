<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<h3 style="color: red"><%=request.getAttribute("msg")%></h3>
<a href="${pageContext.request.contextPath}/index.jsp">返回登录页面</a>
</body>
</html>
