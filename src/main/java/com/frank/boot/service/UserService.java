package com.frank.boot.service;

import com.frank.boot.entities.User;

import java.util.List;

/**
 * @author GuoZhong Xu
 */

public interface UserService {
    void add(User user);

    List<User> showAll();

    User findById(Integer id);

    void edit(User user);

    void deleteById(Integer id);
}
