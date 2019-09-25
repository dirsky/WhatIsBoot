package com.frank.boot.config.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 传统方式
 * <filter>
 *     <filter-name>FirstFilter</filter-name>
 *     <filter-class>com.frank.boot.config.filter.FirstFilter</filter-class>
 * </filter>
 * <filter-mapping>
 *     <filter-name>FirstFilter</filter-name>
 *     <url-pattern>/fs</url-pattern>
 * </filter-mapping>
 *
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 14:22 2019/9/25
 */

@WebFilter(filterName = "FirstFilter", urlPatterns = {"/fs"})
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        System.out.println("begin filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("end filter");
    }

    @Override
    public void destroy() {

    }
}
