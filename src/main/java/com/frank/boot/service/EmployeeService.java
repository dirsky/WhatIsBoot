package com.frank.boot.service;

import com.frank.boot.entities.Employee;
import com.frank.boot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

// cache可以直接写在interface上面不用写在实现上

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(/*cacheNames = "emp",*/key = "#id",condition = "#id>1") // ,key = "#root.methodName+'['+#id+']'"
    public Employee getEmpById(Integer id) {
        System.out.println("查询id=" + id);
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }


    // 两个不同的方法名，会存储不同的方法名字，id也会不同
    // key = "#root.methodName+'['+#id+']'"或者result.id
    @CachePut(cacheNames = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("update"+employee.toString());
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp", key = "#id")
    @Caching
    public void deleteEmp(Integer id) {
        System.out.println("delete:id=" + id);
//        employeeMapper.deleteEmp(id);
    }
}
