<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>

        Hi There!!<%= request.getParameter("name") %> <br/>
        This value was set in the servlet:  <%= request.getAttribute("fakeName") %>
        <br/>
        Session Data:  <%= request.getAttribute("sessionData") %><br>
        <a href="${pageContext.response.encodeRedirectURL('logout')}">Logout</a> <br>
        <%-- <a href="logout">Logout</a> --%>        
        <a href="${pageContext.response.encodeRedirectURL('/Hello2.jsp')}">Other Hello</a>
    </body>
</html>
