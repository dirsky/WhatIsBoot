package com.frank.boot.service.user;

import com.frank.boot.entities.User;

import java.util.List;
import java.util.Map;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 11:31 2020/2/13
 */
public interface UserService {
    String getNameById(Integer id);

    User getUserById(Integer id);

    Map<String, Object> getMapById(Integer id);

    List<User> getUserList();

    List<Map<String, Object>> getMapList();
}
