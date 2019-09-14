package com.frank.boot.service.jpa;

import com.frank.boot.entities.Dept;

import java.util.List;

/**
 * @Author: GuoZhong Xu
 * @Date: 2019/05/13 8:32
 * @Version 1.0
 */
public interface DeptService {

    List<Dept> getList();

    Dept findById(long id);

    void save(Dept user);

    void edit(Dept user);

    void delete(long id);
}
