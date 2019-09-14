package com.frank.boot.controller;

import com.frank.boot.entities.Employee;
import com.frank.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.getEmpById(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {

        employeeService.updateEmp(employee);
        return employee;
    }

    @GetMapping("/empdel")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return id.toString();
    }
}
