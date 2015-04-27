how to run it:

mvn clean install
mvn tomcat7:run

webapp should be up and running on port 9090

go to:

localhost:9090/hello-mvc-servlet

it should be working

- Inspect the code and notice that we have 2 jsp's index.jsp and Hello.jsp
- Inspect FilterOne.java class observe it's implementing javax.servlet.Filter
- go to web.xml and add the following lines before the servlet mapping:

    <filter>
        <filter-name>filterOne</filter-name>
        <filter-class>com.dowa.java.web.filter.FilterOne</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>filterOne</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

- recompile & restart tomcat
- go to localhost:9090/hello-mvc-servlet
- take a look at the console logs
- question why does the page is not shown any more?
- filter intercepted (filtered) the request and has not given it back to the servlet so that's why we don't see anything
- add the following line to FilterOne#doFilter() method
   filterChain.doFilter(servletRequest, servletResponse);

- recompile & restart tomcat
- you should see the page now, so what happened? filterone gave back the response to the chain and after the chain finished it gave it back to servlet
  remember filters use chain of command pattern http://en.wikipedia.org/wiki/Chain-of-responsibility_pattern#Java
- populate the form and submit
- observe in the logs that init method is called only once but doFilter is called each time

- create another filter named FilterTwo (change console log to say filter two instead of one), map it on web.xml,
- delete filterChain.doFilter(servletRequest, servletResponse); from FilterTwo
- what should happen?
- recompile & restart tomcat
- add filterChain.doFilter(servletRequest, servletResponse); to FilterTwo
- what should happen?
- recompile & restart tomcat
- notice that both filters are getting called for each request because  <url-pattern>/*</url-pattern> it's using this wildcard, change the value and see what happens


Task:

- Create a StatisticsFilter that logs on destroy() method how many times a url was accessed
 - url can be accessed using this code:
         //We need to make sure cast is safe
         if (servletRequest instanceof HttpServletRequest) {
             StringBuffer requestURL = ((HttpServletRequest) servletRequest).getRequestURL();
         }
- Create a ParameterFilter that logs all the parameters sent on the request but only for path /hello-mvc-servlet (use <url-pattern> on web.xml)


Questions:

- what else can we achieve using filters?
- how about security? (https://www.owasp.org/index.php/Forced_browsing)
- compression? (http://tutorials.jenkov.com/java-servlets/gzip-servlet-filter.html)


and create a MR