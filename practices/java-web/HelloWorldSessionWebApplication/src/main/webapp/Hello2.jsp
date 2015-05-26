<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>yeha!  Hello again :3 </title>
</head>
<body>
<p>Hello there from this another page :3 </p>
Session Data:  <%= session.getAttribute("mySessionAttribute") %><br>
<a href="logout">Logout</a> <br>
<a href="${pageContext.response.encodeRedirectURL('hello-mvc-servlet')}">Return to first hello</a>
</body>
</html>