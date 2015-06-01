package com.dowa.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String url = "/index.jsp";
        if (session != null) {
            session.invalidate();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }
}