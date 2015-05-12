<%@ page import="java.util.Date" %>
<html>
<body>
<h2>Hello World!   <%= "from JSP" %></h2>
<% Date dt = new Date();%>
<%= dt.toString() %>
</body>
</html>
