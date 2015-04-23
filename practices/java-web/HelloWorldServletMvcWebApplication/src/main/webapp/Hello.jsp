<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>

        Hi There!!<%= request.getParameter("name") %> <br/>
        This value was set in the servlet:  <%= request.getAttribute("fakeName") %>
    </body>
</html>
