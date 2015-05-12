<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>

        Hi There!!<%= request.getParameter("name") %> <br/>
        This value was set in the servlet:  <%= request.getAttribute("fakeName") %>
        <br/>
        Session Data:  <%= session.getAttribute("mySessionAttribute") %>
        <a href="${pageContext.response.encodeRedirectURL('logout')}">Logout</a>
    </body>
</html>
