package com.dowa.java.web.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by rabanita on 5/05/15.
 */
public class StatisticFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("statisticFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException{
        System.out.println("statisticFilter do filter");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy(){
        System.out.println("statisticFilter destroy");
    }
}
