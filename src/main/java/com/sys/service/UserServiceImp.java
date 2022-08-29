package com.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sys.dao.UserDao;
import com.sys.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImp.class);
    @Autowired
    private UserDao userDao;

    public List<User> findUser() {
        List<User> users = userDao.selectList(null);
        return users;
    }

    @Override
    public User findOne(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public String insertUser(User user) {
        return String.valueOf(userDao.insert(user));
    }

    @Override
    public String updateUser(Integer id, User user) {

        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("id", id);
        return String.valueOf(userDao.update(user, wrapper));
    }

    @Override
    public String deleteUser(Integer id) {

        return String.valueOf(userDao.deleteById(id));
    }

    @Override
    public User findOne(User user) {

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(user);
        User one = userDao.selectOne(userQueryWrapper);


        return one;
    }


}
