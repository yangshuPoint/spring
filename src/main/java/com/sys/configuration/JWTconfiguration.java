package com.sys.configuration;

import com.sys.interceptor.JWTinterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JWTconfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new JWTinterceptor());
        // .addPathPatterns("/user/finduser")
        //  .excludePathPatterns("/user/login");

    }
}
