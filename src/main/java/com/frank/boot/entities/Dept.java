package com.frank.boot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@Slf4j
@Entity
public class Dept implements Serializable {
    @Id
    private Long id;
    private String deptName;

    public static void main(String[] args) {
        log.info("frank-dept");
        Dept dept = new Dept();
        log.info(dept.toString());
        Dept frankDept = new Dept(3L, "FrankDept");
        log.info(frankDept.toString());
        log.info(frankDept.getDeptName());
        log.info(frankDept.getId().toString());
        System.out.println(frankDept.hashCode());
        dept.setId(5L).setDeptName("xu");
        System.out.println(dept);
    }
}
