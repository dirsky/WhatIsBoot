package com.frank.boot.mapper;

import com.frank.boot.entities.Employee;
import org.apache.ibatis.annotations.*;


@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email} WHERE id=#{id}")
    void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    void deleteEmp(Integer id);

    @Insert("INSERT INTO employee(lastName,email) VALUES (#{lastName},#{email})")
    void insertEmployee(Employee employee);
}
