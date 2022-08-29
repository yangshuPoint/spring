package com.sys.service;

import com.sys.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> findUser();

    public User findOne(Integer id);

    public String insertUser(User user);

    /**
     * 根据id 修改用户
     *
     * @param id
     * @param user
     * @return
     */
    public String updateUser(Integer id, User user);

    /**
     * 根据id 删除
     *
     * @param id
     * @return
     */
    public String deleteUser(Integer id);

    public User findOne(User user);
}


