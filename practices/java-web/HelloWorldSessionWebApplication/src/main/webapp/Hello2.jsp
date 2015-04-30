<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>The Other Hello</title>
    </head>
    <body>
        <p>Hello from this other page</p>
        Session Data:  <%= session.getAttribute("mySessionAttribute") %><br>
        <a href="logout">Logout</a> <br>
        <a href="${pageContext.response.encodeRedirectURL('hello-mvc-servlet')}">Return to first hello</a>
    </body>
</html>
