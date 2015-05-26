package com.dowa.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class HelloWorldMvcServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String url = "/index.jsp";
        if (session != null) {
            url = "/Hello.jsp";
            setSessionData(req, session);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(resp.encodeRedirectURL(url));
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("fakeName", StringUtils.reverse(name));

        HttpSession session = req.getSession(false);
        if (session == null) {
            session = req.getSession();
        }

        setSessionData(req, session);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(resp.encodeRedirectURL("/Hello.jsp"));
        requestDispatcher.forward(req, resp);
    }

    private void setSessionData(HttpServletRequest req, HttpSession session) {
        String mySessionAttribute = (String) session.getAttribute("mySessionAttribute");
        if (StringUtils.isEmpty(mySessionAttribute)) {
            String sessionData = "Session was created at " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
            System.out.println(sessionData);
            mySessionAttribute = sessionData;
            session.setAttribute("mySessionAttribute", mySessionAttribute);
        }
        req.setAttribute("sessionData", mySessionAttribute);
    }
}