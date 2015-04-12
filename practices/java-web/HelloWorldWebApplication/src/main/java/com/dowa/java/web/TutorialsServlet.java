package com.dowa.java.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.text.*;

public class TutorialsServlet extends HttpServlet {

    class TutorialLink{
        private String url;
        private String description;
        public TutorialLink(String url, String description){
            this.url = url;
            this.description = description;
        }
        public String getUrl(){
            return url;
        }
        public String getDescription(){
            return description;
        }
    }

    private ArrayList<TutorialLink> tutorialsArray;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        tutorialsArray = new ArrayList<TutorialLink>();
        tutorialsArray.add(new TutorialLink("http://www.tutorialspoint.com/jsp/jsp_handling_date.htm","JSP - Handling Date"));
        tutorialsArray.add(new TutorialLink("http://javaweb.osmosislatina.com/curso/jsp.htm","JSP - Curso Java Web"));
        tutorialsArray.add(new TutorialLink("http://www.tutorialspoint.com/java/java_date_time.htm","Java - Date and Time"));
        tutorialsArray.add(new TutorialLink("http://www.tutorialspoint.com/servlets/servlets-quick-guide.htm","Servlets - Quick Guide"));
        ServletOutputStream os = resp.getOutputStream();  

        os.println("<html>");
        os.println("<body>");

        os.println("<h2>");
        os.println("These are the Tutorials I read to make this practice: ");
        os.println("</h2>");

       

        os.println("<ul>");
        this.printLinks(os, tutorialsArray);
        os.println("</ul>");

        os.println("</body>");
        os.println("</html>");

        os.flush();
    }

    private void printLinks( ServletOutputStream os , ArrayList<TutorialLink> tutorialsArray)  throws ServletException, IOException {
        for(TutorialLink tutorial : tutorialsArray){
            os.println("<li>");
            os.println("<a href='"+tutorial.getUrl() + "' target='_blank' >");
            os.println(tutorial.getDescription());
            os.println("</a>");
            os.println("</li>");
        }
    }
}