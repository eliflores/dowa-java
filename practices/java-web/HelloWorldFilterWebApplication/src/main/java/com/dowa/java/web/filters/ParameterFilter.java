package com.dowa.java.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ParameterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ParameterFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException{
        System.out.println("ParameterFilter do filter");

        if (servletRequest instanceof HttpServletRequest) {
            //StringBuffer requestURL = ((HttpServletRequest) servletRequest).getRequestURL();
            String name = servletRequest.getParameter("name");
            System.out.println("Your name is " + name);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy(){
        System.out.println("ParameterFilter destroy");
    }
}
