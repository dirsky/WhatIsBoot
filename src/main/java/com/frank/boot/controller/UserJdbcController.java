package com.frank.boot.controller;

import com.frank.boot.service.user.UserService;
import com.frank.boot.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 9:55 2020/2/13
 */
@RestController
@RequestMapping("/user/jdbc")
@Slf4j
public class UserJdbcController {

    @Autowired
    private UserService userJdbcService;

    @GetMapping("/getname")
    public String  getNameById(Integer id) {
        log.info("UserJdbcController-getname");
        return userJdbcService.getNameById(id);
    }

    @GetMapping("/getuser")
    public User getUserById(Integer id) {
        return userJdbcService.getUserById(id);
    }

    /**
     * 和getUserById返回到前端的结果相同
     * @param id
     * @return
     */
    @GetMapping("/getmap")
    public Map<String, Object> getMapById(Integer id) {
        return userJdbcService.getMapById(id);
    }

    @GetMapping("/getuserlist")
    public List<User> getUserList() {
        return userJdbcService.getUserList();
    }

    @GetMapping("/getmaplist")
    public List<Map<String, Object>> getMapList() {
        return userJdbcService.getMapList();
    }
}
