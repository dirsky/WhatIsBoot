package com.frank.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Slf4j
public class DemoService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 事务一致性
    @Transactional
    public void insert() {
        log.info("纯粹做测试");

        try {
            jdbcTemplate.update("insert into employee (lastName) values (?)","HI");
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        int a = 1 / 0;
    }
    public void insertWithoutTransactional() {
        log.info("纯粹做测试");

        try {
            jdbcTemplate.update("insert into employee (lastName,email) values (?,?)",
                    "HI",new Date());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        int a = 1 / 0;
    }
}
