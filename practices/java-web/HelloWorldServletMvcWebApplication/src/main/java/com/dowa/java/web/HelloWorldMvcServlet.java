package com.dowa.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class HelloWorldMvcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Hello.jsp");
        RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("/Error.jsp");

        boolean isStudent = false;
        String name = req.getParameter("name");
        ArrayList names = new ArrayList();
        //req.setAttribute("fakeName", StringUtils.reverse(name));

        names.add("Nexuz");
        names.add("Nana");
        names.add("Bruce");
        names.add("Mary");
        names.add("2Pac");

        if (names.contains(name)){
            isStudent = true;
            req.setAttribute("isStudent", isStudent);
            requestDispatcher.forward(req,resp);
        } else{
            req.setAttribute("isStudent", isStudent);
            requestDispatcher1.forward(req, resp);
        }

    }
}