<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirection</title>
    <meta http-equiv="refresh" content="0; URL=${pageContext.request.contextPath}/login.do">
</head>
<body>
<% response.sendRedirect(request.getContextPath() + "/login.do"); %>
</body>
</html>