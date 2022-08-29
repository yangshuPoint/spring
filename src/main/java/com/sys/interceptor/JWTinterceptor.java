package com.sys.interceptor;

import com.sys.util.Jwtutil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JWTinterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        System.out.println(map.toString());
        System.out.println(map.get("token"));
        System.out.println("---------------------------------------------");
        System.out.println(map.get("token1"));

        String token1 = request.getHeader("token1");
        String token = request.getHeader("token");

        System.out.println("```````````````2222222222222222222222222222222");
        System.out.println("-----------------------pre :  " + token);
        System.out.println("-------------------Response:sethand----pre :  " + token1);
        try {
            Jwtutil.verif(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
