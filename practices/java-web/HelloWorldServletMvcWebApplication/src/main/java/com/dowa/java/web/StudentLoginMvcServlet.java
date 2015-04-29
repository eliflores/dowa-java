package com.dowa.java.web;

import com.dowa.java.web.repository.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class StudentLoginMvcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher requestDispatcher;
        String target = "/index.jsp"; //if something goes wrong
        StudentRepository repo = new StudentRepository();
        String name = req.getParameter("name");
        try {
            if(repo.findStudentByFirstName(name).getFirstName() != null) {
                req.setAttribute("name", name);
                target = "/home.jsp";
            }else{
                req.setAttribute("message", "Sorry. Your name was not found in the database.");
                target = "/login.jsp";
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }catch (RuntimeException e) {
            System.err.println("RuntimeException: " + e.getMessage());
        }

        requestDispatcher = req.getRequestDispatcher(target);
        requestDispatcher.forward(req, resp);
    }
}