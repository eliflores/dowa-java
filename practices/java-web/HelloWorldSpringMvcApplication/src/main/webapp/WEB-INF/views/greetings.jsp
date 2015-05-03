<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Hello from Spring MVC</title>
    </head>
    <body>
        <h2>Hello ${name} and welcome to Diagon Alley.</h2>
        <p>Here you can find all kind of shops for your return to Hogwarts,from an new broom (at Broomstix)
        or your books (at Flourish and Blotts);at the end of the alley you can find Gringotts Wizarding Bank where you
        can get your money. Remember the Golden one is a Galleon, the silver one is a sickle and the bronze one is a knut.</p>
        If you want to go to the dark side <a href="/hello-spring-mvc/"> click here </a>
    </body>
</html>
