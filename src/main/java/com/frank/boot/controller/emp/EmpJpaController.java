package com.frank.boot.controller.emp;

import com.frank.boot.entities.Emp;
import com.frank.boot.repository.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 18:13 2020/2/14
 */
@RestController
@RequestMapping("/jpa")
public class EmpJpaController {
    @Autowired
    private EmpDao empDao;
    /**
     * 必须在实体上标注@Entity和@Id
     * @return
     */
    @GetMapping("/list")
    public List<Emp> list() {
        return empDao.findAll();
    }
}
