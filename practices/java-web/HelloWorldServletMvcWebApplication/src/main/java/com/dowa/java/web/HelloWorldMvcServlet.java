package com.dowa.java.web;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldMvcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Hello.jsp");

        String name = req.getParameter("name");

        req.setAttribute("fakeName", StringUtils.reverse(name));
        requestDispatcher.forward(req, resp);
       /* ArrayList names = new ArrayList();
        names.add("Miriam");
        names.add("Antonio");
        names.add("El Moy");
        names.add("Ivan");

        if (names.contains(name)) {
            requestDispatcher.forward(req, resp);
        } else{
           //Ver como escribir en la misma pagina donde estoy
        }*/
    }
}