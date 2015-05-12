package com.dowa.java.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class StatisticsFilter implements Filter {

    private int contadorVisitasIndex = 0;
    private int contadorVisitasHello = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init StatisticsFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        if(servletRequest instanceof HttpServletRequest){
            String requestURL = ((HttpServletRequest) servletRequest).getRequestURL().toString();
            String indexURL = "http://localhost:9090/index.jsp";
            String helloURL = "http://localhost:9090/hello-mvc-servlet";
            if(requestURL.equals(indexURL)){
                contadorVisitasIndex++;
            }
            else if (requestURL.equals(helloURL)){
                contadorVisitasHello++;
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("El numero de visitas a index fue "+ contadorVisitasIndex);
        System.out.println("El numero de visitas a hello fue "+ contadorVisitasHello);
    }
}