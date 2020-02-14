package com.frank.boot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 16:24 2020/2/14
 */
@Configuration
public class PageConfig {
    /**
     * 实现Mybatis-plus的分页功能
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
