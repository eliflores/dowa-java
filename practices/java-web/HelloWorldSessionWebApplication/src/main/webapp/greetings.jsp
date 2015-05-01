<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <%String name = request.getParameter("param");%>
        <h1>Hi There!! <h1/>
        <h3><%=name%>, I love your name n.n<h3/>
        You!!! yeah you <%=name%>! you should go and watch Avengers!!

        Do you want to go back? <a href="${pageContext.response.encodeRedirectURL('hello-mvc-servlet')}">click here!</a>
        If you want to end the session <a href="${pageContext.response.encodeRedirectURL('logout')}">Logout</a> <%-- //encodeRedirectURL se encarga de enviar la
        sesion cuando no estan habilitadas las cookies--%>
        <%--<a href="logout">Logout</a>--%>
    </body>
</html>
