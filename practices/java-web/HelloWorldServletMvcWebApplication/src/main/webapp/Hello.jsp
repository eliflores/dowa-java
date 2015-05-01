<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <%
        <T> insideList = request.getAttribute("inList");
        if(insideList.equals(true)){
        %>
            Hi There!!<%= request.getParameter("name") %>
        <%
        }else{
        %>
            Sorry, there was no <%= request.getParameter("name")%> in the list.
        <%
        }
        %>
    </body>
</html>
