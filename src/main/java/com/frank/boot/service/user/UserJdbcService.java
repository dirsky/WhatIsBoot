package com.frank.boot.service.user;

import com.frank.boot.dao.UserDao;
import com.frank.boot.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 10:56 2020/2/13
 */
@Service
@Slf4j
public class UserJdbcService implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String getNameById(Integer id) {
        log.info("UserJdbcService-getNameById");
        return userDao.getNameById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    /**
     * 和getUserById返回到前端的结果相同
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getMapById(Integer id) {
        return userDao.getMapById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public List<Map<String, Object>> getMapList() {
        return userDao.getMapList();
    }
}
