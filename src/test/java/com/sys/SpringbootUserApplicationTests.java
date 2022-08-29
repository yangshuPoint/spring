package com.sys;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootUserApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(SpringbootUserApplicationTests.class);

    @Test
    void contextLoads() {

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager(
                new IniRealm("classpath:shiro.ini")
        );
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("yangshu", "111");

        try {
            subject.login(token);
            log.info("----------------------认证通过");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误!!!");
        }

    }


}