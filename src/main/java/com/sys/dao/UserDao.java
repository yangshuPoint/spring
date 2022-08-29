package com.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {




}
