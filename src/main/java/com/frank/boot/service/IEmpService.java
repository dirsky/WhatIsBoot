package com.frank.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.boot.entities.Emp;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 18:09 2020/2/14
 */
public interface IEmpService extends IService<Emp> {
    Emp mySelect(Long id);
}
