package com.frank.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.boot.entities.Emp;
import com.frank.boot.mapper.EmpMapper;
import com.frank.boot.service.IEmpService;
import org.springframework.stereotype.Service;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 18:10 2020/2/14
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Override
    public Emp mySelect(Long id) {
        return this.baseMapper.mySelect(id);
    }
}
