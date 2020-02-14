package com.frank.boot.controller.emp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.frank.boot.entities.Emp;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 18:18 2020/2/14
 */
@RestController
@RequestMapping("/model")
public class EmpModelController {
    @GetMapping("/list")
    public List<Emp> list() {
        List<Emp> emps = new Emp().selectAll();
        return emps;
    }

    @GetMapping("/update")
    public Boolean update() {
//        boolean huang = new Emp().setId(40).setName("Huang").updateById();
        UpdateWrapper<Emp> wrapper = new UpdateWrapper<>();
        wrapper.like("name", "giant");
        boolean giant = new Emp().setName("cc").update(wrapper);
        return giant;

    }

    @GetMapping("/insert")
    public Boolean insert(@Valid Emp emp, BindingResult result) {

        Boolean flag = false;
        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> {
                FieldError fieldError = (FieldError) e;
                String model = fieldError.getObjectName();
                String filed = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                System.out.println(model + " - " + filed + " - " + message);
            });
        } else {
            Emp e = new Emp().setId(emp.getId()).setName(emp.getName());
            flag = e.insert();
        }
        return flag;
    }
}
