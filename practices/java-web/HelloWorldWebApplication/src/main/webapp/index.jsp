<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<html>
<body>
<h2>Hello World!   <%= "from JSP" %></h2>

<%!
   Date date = new Date();
    SimpleDateFormat ft = 
   new SimpleDateFormat ("'Today is' E yyyy - MM - dd 'at' hh:mm:ss ");  
%>
<h2> <%= ft.format(date) %></h2>
</body>
</html>
