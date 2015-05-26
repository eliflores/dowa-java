
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi, we need your information.</title>
</head>
<body>
<h2>This is the pages of the student if this one is register before</h2>
<p>Please fill the fields with your information.</p>
<% if(request.getAttribute("message") != null){ %>
<p style="color: red"> <%= request.getAttribute("message") %> </p>
<% } %>
  <form method="post" action="/login-servlet">
    <label for="name">First name:</label>
    <input type="text" name="name" id="name" />
    <input type="submit"/>
  </form>
</body>
</html>
