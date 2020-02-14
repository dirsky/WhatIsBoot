package com.frank.boot.dao;

import com.frank.boot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 10:54 2020/2/13
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getNameById(Integer id) {
        String sql = "select name from users where id=?;";
        String name = jdbcTemplate.queryForObject(sql, String.class, id);
        return name;
    }

    public User getUserById(Integer id) {
        String sql = "select id,name from users where id=?;";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    /**
     * 和getUserById返回到前端的结果相同
     *
     * @param id
     * @return
     */
    public Map<String, Object> getMapById(Integer id) {
        String sql = "select id,name from users where id=?;";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }

    public List<User> getUserList() {
        String sql = "select id,name from users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    public List<Map<String, Object>> getMapList() {
        String sql = "select id,name from users";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
