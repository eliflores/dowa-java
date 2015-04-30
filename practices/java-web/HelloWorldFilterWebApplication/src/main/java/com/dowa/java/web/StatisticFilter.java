package com.dowa.java.web;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;


public class StatisticFilter implements Filter {
    private int visitsIndex;
    private int visitsHello;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        visitsHello = 0;
        visitsIndex = 0;
        System.out.println("Statisctic init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException{
        System.out.println("Statisctic do filter");
        if (servletRequest instanceof HttpServletRequest) {
             StringBuffer requestURL = ((HttpServletRequest) servletRequest).getRequestURL();
             if(requestURL.toString().equals("http://localhost:9090/")){
                visitsIndex ++;
            }
            else if(requestURL.toString().equals("http://localhost:9090/hello-mvc-servlet")){
                visitsHello ++;
            }
         }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //I don't if this was the goal of the practice
        System.out.println("Statisctic filter destroy");
        System.out.println("Visits to http://localhost:9090/  "+String.valueOf(visitsIndex));
        System.out.println("Visits to http://localhost:9090/hello-mvc-servlet  "+String.valueOf(visitsHello));
    }
}
