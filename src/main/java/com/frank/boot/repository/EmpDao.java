package com.frank.boot.repository;

import com.frank.boot.entities.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 18:12 2020/2/14
 */
@Repository
public interface EmpDao extends JpaRepository<Emp, Integer> {
}
