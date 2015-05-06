package com.dowa.java.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class StatisticFilter implements Filter {
    private int indexVisitNum = 0;
    private int mvcServletVisitNum = 0;

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
            if (requestURL.toString().equals("http://localhost:9090/")){
                indexVisitNum += 1;
            } else if (requestURL.toString().equals("http://localhost:9090/hello-mvc-servlet")) {
                mvcServletVisitNum += 1;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy(){
        System.out.println("There where " + String.valueOf(indexVisitNum) + " visits on localhost:9090/");
        System.out.println("There where " + String.valueOf(mvcServletVisitNum) + " visits on localhost:9090/hello-mvc-servlet");
        int tot = indexVisitNum + mvcServletVisitNum;
        System.out.println("The sum of the visits was = " + String.valueOf(tot));
        System.out.println("statisticFilter destroy");
    }
}
