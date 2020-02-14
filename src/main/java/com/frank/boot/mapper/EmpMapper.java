package com.frank.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.boot.entities.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 18:08 2020/2/14
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    Emp mySelect(Long id);
}
