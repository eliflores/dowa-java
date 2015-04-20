<%@ page import="Java.util.*"%>
<%@ page import="Java.text.*"%>
<%@ page import="Java.io.*"%>
<html>
<body>
<h2>Hello World!   <%= "from JSP" %></h2>
<% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); %>
<% Date date = new Date(); %>
<h3>Fecha: <%= dateFormat.format(date) %> </h3>
</body>
</html>