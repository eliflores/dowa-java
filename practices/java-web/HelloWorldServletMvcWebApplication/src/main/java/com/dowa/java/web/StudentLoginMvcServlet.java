package com.dowa.java.web;

/**
 * Created by Tonoid on 5/20/2015.
 */

//we use this because is the repository for our Login studend servlet
//in this form we can have MVC view.
import com.dowa.java.web.repository.StudentRepository;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class StudentLoginMvcServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher requestDispatcher;

        String target = "/index.jsp";

        StudentRepository repo = new StudentRepository();
        String name = req.getParameter("name");

        try {
            if(repo.findStudentByFirstName(name).getFirstName() != null) {
                req.setAttribute("name", name);
                target = "/home.jsp"; //then this user already have an acount.
            }else{
                req.setAttribute("message", "Sorry. Your name was not found in the database.");
                target = "/login.jsp";//then this student didnt exist in our database.
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
