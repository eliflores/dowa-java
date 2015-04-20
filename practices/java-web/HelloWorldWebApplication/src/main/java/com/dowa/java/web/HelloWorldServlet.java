package com.dowa.java.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        ServletOutputStream os = resp.getOutputStream();

        os.println("<html>");
        os.println("<body>");

        os.println("<h2>");
        os.println("Hello World! from a servlet");
        os.println("</h2>");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        os.println("<h2>Date: ");
        os.println(dateFormat.format(date));
        os.println("</h2>");

        os.println("</body>");
        os.println("</html>");

        os.flush();
    }
}