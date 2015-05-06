package com.dowa.java.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class StatisticFilter implements Filter {
    private int visitNum = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("statisticFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException{
        System.out.println("statisticFilter do filter");

        if (servletRequest instanceof HttpServletRequest) {
            StringBuffer requestURL = ((HttpServletRequest) servletRequest).getRequestURL();
            if (requestURL.toString().equals("http://localhost:9090/hello-mvc-servlet")){
                visitNum += 1;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy(){
        System.out.println("There where " + String.valueOf(visitNum) + " visits to localhost:9090/hello-mvc-servlet");
        System.out.println("statisticFilter destroy");
    }
}
