how to run it:

mvn clean install
mvn tomcat7:run

webapp should be up and running on port 9090

go to:

localhost:9090/hello-mvc-servlet

- on the view insert your name and click submit
- notice that the servlet process it and the JSP presents the view
- It will show your name and also your name in reversed form

questions to ask:
- What is the difference between attributes and parameters?
- Is this an MVC way to work with servlets?


your task is to:
Create a login form that make use of StudentRepository from a previous practice, also make sure to implement this using mvc

Requirements:
 - As a user I should be able to login If I'm a valid student (ignore password for now)
 - If login is successful then need to redirect to home.jsp (like we do it for hello-mvc-servlet) and present the name of the student


and create a MR