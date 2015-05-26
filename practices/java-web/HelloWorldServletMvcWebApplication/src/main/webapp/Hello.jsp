<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>

        Hi :D !!<%= request.getParameter("name") %> <br/>
        This value was set in this servlet:  <%= request.getAttribute("fakeName") %>
    </body>
</html>
