<%@ page import="java.util.Date" %>
<c:set var="now" value="<%=new java.util.Date()%>" />
<html>
<body>
<h1>Hello World!   <%= "from JSP" %></h1>
<%
    Date date = new Date();
    out.print( "<h2 align=\"center\">" +date.toString()+"</h2>");
%>
</body>
</html>
