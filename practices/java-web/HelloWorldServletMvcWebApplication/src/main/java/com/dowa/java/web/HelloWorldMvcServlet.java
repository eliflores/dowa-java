package com.dowa.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.dowa.java.web.model.Student;
import com.dowa.java.web.repository.StudentRepository;
import org.apache.commons.lang3.StringUtils;

public class HelloWorldMvcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        String name = req.getParameter("name");
        req.setAttribute("fakeName", StringUtils.reverse(name));

        StudentRepository repo = new StudentRepository();
        Student search = null;
        try {
            search = repo.findStudentByFirstName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(search != null && search.getFirstName() != null){
            requestDispatcher = req.getRequestDispatcher("/Hello.jsp");
        }
        requestDispatcher.forward(req, resp);
    }
}