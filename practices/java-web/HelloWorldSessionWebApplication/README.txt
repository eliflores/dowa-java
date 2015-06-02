how to run it:

mvn clean install
mvn tomcat7:run

webapp should be up and running on port 9090

go to:

localhost:9090/hello-mvc-servlet

it should be working

Observe:
- web.xml is 2.4 instead of 2.3 to allow EL to be interpreted
- Code for HelloWorldMvcServlet#doGet() will redirect to Hello.jsp if there is an existing session if not it will redirect to index.jsp
- Code for HelloWorldMvcServlet#doPost() will create a session if there is none store information on the session if it's not already set
- go to localhost:9090/hello-mvc-servlet populate the form, submit it
- Session data should show time of creation
- refresh the url http://localhost:9090/hello-mvc-servlet and see that the session data doesn't change
- use browser inspection tools to see the available cookies on a browser and look for cookie JSESSIONID
- click on logout
- refresh the url http://localhost:9090/hello-mvc-servlet see that the time of creation has been changed
- use browser inspection tools to see the available cookies on a browser and look for cookie JSESSIONID value should
- Configured session timeout on web.xml is 1 minute

Questions:
- what happens if we always use req.getSession();?<
- what happens if we use implicit object session ?
- what happens if we change the value of jsessionID manually (use browser tools)


Task:
- disable browser cookies (use browser extension http://chrispederick.com/work/web-developer/)
- repeat steps for observe how have they changed?
- add a link on home.jsp to another page home2.jsp using urlre-writing home2.jsp should show sessionData value
- use URL rewriting to overcome cookie disabling
    RequestDispatcher requestDispatcher = req.getRequestDispatcher(resp.encodeRedirectURL("/Hello.jsp"));
    inspect logout URL should read something like:
        http://localhost:9090/logout;jsessionid=F7281A8873E767084E917492C7EA990C
- notice how on every request sessionId is passed in the url
- Use implicit object to get a new field from the session
- create a MR