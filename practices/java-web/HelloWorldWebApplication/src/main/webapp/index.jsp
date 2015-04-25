<%@page import="java.util.Date,java.text.*, java.io.*" %>
<html>
<body>
<h2>Hello World!   <%= "from JSP" %></h2>
<% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); %>
<% Date date = new Date(); %>
<h3>Date: <%= dateFormat.format(date) %> </h3>
</body>
</html>
</html>