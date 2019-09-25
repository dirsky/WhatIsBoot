package com.frank.boot.config.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 传统方式
 * <listener>
 *     <listener-class>com.frank.boot.config.listener.FirstListener</listener-class>
 * </listener>
 *
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 14:35 2019/9/25
 */

@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener...init......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
