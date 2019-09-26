package com.frank.boot.service.impl;

import com.frank.boot.entities.User;
import com.frank.boot.mapper.UserMapper;
import com.frank.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 16:46 2019/9/25
 */

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> showAll() {
        return userMapper.selectAll();
    }

    /**
     * Cacheable:对当前查询的对象做缓存处理
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "user")
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * CacheEvict清除缓存中以 users 缓存策略缓存的对象
     * @param user
     */
    @Override
    @CacheEvict(value = "user",allEntries = true)
    public void edit(User user) {
        userMapper.update(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
