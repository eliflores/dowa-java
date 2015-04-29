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

public class ParameterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Parameter filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        System.out.println("Parameter do filter");
        if (servletRequest instanceof HttpServletRequest) {
            StringBuffer requestURL = ((HttpServletRequest) servletRequest).getRequestURL();
            if(servletRequest.getParameterMap().containsKey("name")){
                String name = servletRequest.getParameter("name");
                System.out.println("Parameter received: "+name);
            }
         }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Parameter filter destroy");
    }
}
