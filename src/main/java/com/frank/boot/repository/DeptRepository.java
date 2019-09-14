package com.frank.boot.repository;

import com.frank.boot.entities.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: GuoZhong Xu
 * @Date: 2019/05/13 8:30
 * @Version 1.0
 */
public interface DeptRepository extends JpaRepository<Dept,Integer> {
    Dept findById(long id);

    void deleteById(Long id);
}
