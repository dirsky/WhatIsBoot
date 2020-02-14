package com.frank.boot.controller.emp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frank.boot.entities.Emp;
import com.frank.boot.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 15:02 2020/2/14
 */
@RestController
@RequestMapping("/service")
public class EmpServiceController {

    @Autowired
    private IEmpService empService;

    @GetMapping("/list")
    public List<Emp> list() {
        return empService.list();
    }

    @PutMapping("/saveOrUpdate")
    public Boolean saveOrUpdate() {
        Emp pig = new Emp().setId(20).setName("pig20");
        return empService.saveOrUpdate(pig);
    }

    @PutMapping("/saveOrUpdateBatch")
    public Boolean saveOrUpdateBatch() {
        List<Emp> emps = Arrays.asList(
                new Emp().setId(30).setName("giant30"),
                new Emp().setId(31).setName("giant30"),
                new Emp().setId(32).setName("giant30")
        );
        empService.saveOrUpdateBatch(emps);
        List<Emp> emps2 = Arrays.asList(
                new Emp().setId(40).setName("giant40"),
                new Emp().setId(41).setName("giant40"),
                new Emp().setId(42).setName("giant40"),
                new Emp().setId(43).setName("giant40"),
                new Emp().setId(44).setName("giant40")
        );
//        默认batchSize=1000
        return empService.saveOrUpdateBatch(emps2,3);
    }

    @DeleteMapping("/remove")
    public Boolean remove() {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.like("name", "giant");
        return empService.remove(wrapper);
    }

    /**
     * 需要配置PaginationInterceptor
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/page")
    public IPage<Emp> getPage(Integer current, Integer size) {
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.like("name", "giant");
        Page<Emp> queryPage = new Page<>(current, size);
        return empService.page(queryPage);
    }
}
