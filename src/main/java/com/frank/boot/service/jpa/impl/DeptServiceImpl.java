package com.frank.boot.service.jpa.impl;

import com.frank.boot.entities.Dept;
import com.frank.boot.repository.DeptRepository;
import com.frank.boot.service.jpa.DeptService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: GuoZhong Xu
 * @Date: 2019/05/13 8:37
 * @Version 1.0
 */
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<Dept> getList() {
        return deptRepository.findAll();
    }

    @Override
    public Dept findById(long id) {
        return deptRepository.findById(id);
    }

    @Override
    public void save(Dept dept) {
        deptRepository.save(dept);
    }

    @Override
    public void edit(Dept dept) {
        deptRepository.save(dept);
    }

    @Override
    public void delete(long id) {
        deptRepository.deleteById(id);
    }
}
