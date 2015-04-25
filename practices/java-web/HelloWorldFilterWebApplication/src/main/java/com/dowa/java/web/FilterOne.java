package com.dowa.java.web;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter one init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        System.out.println("filter one do filter");
        filterChain.doFilter(servletRequest, servletResponse);

        if (servletRequest instanceof HttpServletRequest) {
            StringBuffer requestURL = ((HttpServletRequest) servletRequest).getRequestURL();
        }

    }

    @Override
    public void destroy() {
        System.out.println("Filter one destroy");
    }
}
