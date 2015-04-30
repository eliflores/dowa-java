<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>


<html>
<body>
<h2>Hello World!   <%= "from JSP" %></h2>
<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
%>

    <%= sdf.format(date) %>
</body>
</html>
