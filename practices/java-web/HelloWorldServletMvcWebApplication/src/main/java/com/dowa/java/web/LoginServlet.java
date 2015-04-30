package com.dowa.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.dowa.java.repository.StudentRepository;
import org.apache.commons.lang3.StringUtils;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        RequestDispatcher requestDispatcher = null;

        try {
            if(StudentRepository.findStudentByFirstName(name) != null) {
                requestDispatcher = req.getRequestDispatcher("/home.jsp");
            }
            else{
                req.setAttribute("error", "Error... you are not in the list");
                requestDispatcher = req.getRequestDispatcher("/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        requestDispatcher.forward(req, resp);
    }
}