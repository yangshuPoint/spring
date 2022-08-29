package com.sys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sys.pojo.User;
import com.sys.service.UserService;
import com.sys.util.Jwtutil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "当前为用户接口")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    private ObjectMapper objectMapper;

    @ApiOperation(value = "查询所有用户")
    @GetMapping("user/finduser")
    public List<User> findAll() {

        return userService.findUser();
    }

    @GetMapping("user/findone/{id}")
    @ApiOperation("基于id查询")
    public String findOne(@PathVariable Integer id) throws JsonProcessingException {
        log.info("------------id:" + id);
        log.info(userService.findOne(id).toString());
        System.out.println(userService.findOne(id).toString());
        System.out.println("-----------------------------------------------------------");

        return objectMapper.writeValueAsString(userService.findOne(id));

    }

    @PostMapping("user/insert")
    @ApiOperation(value = "添加用户")
    public String inserUser(@RequestBody User user) {
        log.info("用户：" + user.getName() + "被创建");
        return userService.insertUser(user);
    }

    @PutMapping("user/update/{id}")
    @ApiOperation(value = "根據id修改")
    public String updaeuser(@PathVariable Integer id, @RequestBody User user) {

        log.info("-----------" + id + "号用户名字：" + user.getName());
        return userService.updateUser(id, user);

    }

    @ApiOperation(value = "根据id删除用户")
    @DeleteMapping("user/delete/{id}")
    public String delete(@PathVariable Integer id) {

        log.info("`````````````" + id + "号用户被删除");
        return userService.deleteUser(id);
    }


    @GetMapping("user/login/{name}")
    public Map<String, String> login(@PathVariable String name, HttpServletResponse response) {

        Map<String, String> map = new HashMap<>();


        User one = userService.findOne(new User().setName(name));

        if (one != null && !one.getName().isEmpty()) {
            String token = Jwtutil.getToken(one.getName());
            log.info("token:" + token);
            log.info("登录成功生成：++++++++++++token:" + token);
            log.info("token:" + token);
            map.put("token", token);
            response.setHeader("token1", token);
        }

        return map;
    }

}
