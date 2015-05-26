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

//to do the statistics of the pages.
public class StatisticFilter implements Filter {


    private int visitsIndex;
    private int visitsHello;

    //this function only runs one time, this happend when the whole app begins to run.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        visitsHello = 0;
        visitsIndex = 0;
        System.out.println("Statisctic in (init) function");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException{


        System.out.println("Statisctic in (doFilter) function");


        if (servletRequest instanceof HttpServletRequest) {
            StringBuffer requestURL = ((HttpServletRequest) servletRequest).getRequestURL();
            if(requestURL.toString().equals("http://localhost:9090/")){
                visitsIndex ++; //then we do ++ to the statistics.
                System.out.println("visits index " +  visitsIndex); //just to see in console.
            }
            else if(requestURL.toString().equals("http://localhost:9090/hello-mvc-servlet")){
                visitsHello ++;
                System.out.println("visits index " +  visitsHello); //just to see in console.
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

        System.out.println("Statisctic filter destroy");
        System.out.println("Visits to http://localhost:9090/  "+String.valueOf(visitsIndex));
        System.out.println("Visits to http://localhost:9090/hello-mvc-servlet  "+String.valueOf(visitsHello));
    }
}