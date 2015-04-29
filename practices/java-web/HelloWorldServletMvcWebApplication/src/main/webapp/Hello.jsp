<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <% if(request.getAttribute("inList") == true) {%>
            Hi There!!<%= request.getParameter("name") %>
        <%} else{%>
            Sorry, there was no <%= request.getParameter("name")%> in the list.
        <%}%>
    </body>
</html>
