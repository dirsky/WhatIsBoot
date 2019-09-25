package com.frank.boot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 方式一：
 * <servlet>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <servlet-class>com.frank.boot.servlet.FirstServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <url-pattern>/first</url-pattern>
 * </servlet-mapping>
 * @author Guozhong Xu
 * @date Create in 14:09 2019/9/25
 * @version 1.0
 */
// 在启动类开启@ServletComponentScan //指定去扫描Servlet注解

@WebServlet(name = "FirstServlet", urlPatterns = "/fs")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FirstServlet");
    }
}
