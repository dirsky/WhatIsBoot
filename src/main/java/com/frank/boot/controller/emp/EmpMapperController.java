package com.frank.boot.controller.emp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.frank.boot.entities.Emp;
import com.frank.boot.entities.Employee;
import com.frank.boot.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 18:14 2020/2/14
 */
@RestController
@RequestMapping("/emp")
public class EmpMapperController {
    @Autowired
    private EmpMapper empMapper;

    @GetMapping("/list")
    public List<Emp> list() {
        return empMapper.selectList(null);
    }

    @PostMapping("/save")
    public Integer save(Integer id, String name, String email, Integer gender, Integer age) {
        Emp emp = new Emp(id, name, email, gender, age);
        int num = empMapper.insert(emp);
        return num;
    }

    /**
     * 删除-有且只有通过id删除
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById")
    public Integer deleteById(Integer id){
        return empMapper.deleteById(id);
    }

    /**
     * 删除-通过很多个id删除
     * @param ids
     * @return
     */
    @DeleteMapping("/deleteBatchIds")
    public Integer deleteBatchIds(String ids) {
        String[] split = ids.trim().split(",");
        List<String> list = Arrays.asList(split);
        return empMapper.deleteBatchIds(list);
    }

    /**
     * 删除-通过构造复杂的条件构造器删除
     * @param name
     * @return
     */
    @DeleteMapping("/delete")
    public Integer delete(String  name) {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name).lt("age",3);
        return empMapper.delete(queryWrapper);
    }

    /**
     * 删除-通过简单的相等条件进行删除
     * @return
     */
    @DeleteMapping("/deleteByMap")
    public Integer deleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "cat");
        map.put("age", null);
        return empMapper.deleteByMap(map);
    }

    @PutMapping("/updateById")
    public Integer updateById() {
        Emp emp = new Emp().setId(14).setEmail("11");
        return empMapper.updateById(emp);
    }

    @PutMapping("/update")
    public Integer update() {
        UpdateWrapper<Emp> wrapper = new UpdateWrapper<>();
        // 当然不通过.set("gender",0)语句也可以通过实体部分进行条件赋值
        wrapper.lt("age",10).set("gender",0);
        return empMapper.update(null, wrapper);
    }

    @GetMapping("/my")
    public Emp mySelect(Long id) {
        Emp employee = empMapper.mySelect(id);
        return employee;
    }
}
