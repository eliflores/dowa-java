<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Students Login Page</h2>
<p>Please fill the fields with your information.</p>
<% if(request.getAttribute("message") != null){ %>
    <p style="color: red"> <%= request.getAttribute("message") %></p>
<% } %>
    <form method="post" action="/login-mvc-servlet">
        <label for="name">First name:</label>
        <input type="text" name="name" id="name" />
        <input type="submit"/>
    </form>
</body>
</html>
