package com.dowa.java.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date time = new Date();
        resp.setContentType("text/html");

        ServletOutputStream os = resp.getOutputStream();

        os.println("<html>");
        os.println("<body>");

        os.println("<h1>");
        os.println("Hello World! from a servlet");
        os.println("</h1>");

        os.println("<h2>");
        os.println("Current time: "+ time.toString()+ " ");
        os.println("</h2>");

        os.println("</body>");
        os.println("</html>");

        os.flush();
    }
}