package com.dowa.java.web.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by rabanita on 5/05/15.
 */
public class FilterTwo implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter two init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("filter two do filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

        System.out.println("Filter two destroy");
    }
}
