<%--
  Created by IntelliJ IDEA.
  User: Tonoid
  Date: 5/20/2015
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body style="text-align:center;">
<div style="font-size: 24">
  Hello <%= request.getParameter("name") %>! <br>
  Now you're logged to the page.
</div>
<a href="/login.jsp">Return to login page</a>
</body>
</html>
