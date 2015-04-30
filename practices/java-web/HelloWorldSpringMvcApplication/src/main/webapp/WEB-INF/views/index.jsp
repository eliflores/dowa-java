<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Hello from Spring MVC</title>
    </head>
    <body>
        <p>Controller says: ${message} </p>

        <form title="Who are you?" name="who-are-you" method="post" action="/hello-spring-mvc-params">
            <label>What is your name?</label>
            <input type="text" name="name"/>
            <input type="submit"/>
        </form>

    </body>
</html>
