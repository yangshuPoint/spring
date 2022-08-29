package com.sys.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    static ObjectMapper objectMapper;


    public   static  String tostring(Object obj)  {


        try {
           return    objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {

            log.info("json处理异常", e.getMessage());
            throw  new RuntimeException();
        }


    }



    public  static Object tobject(String  str,Class<?> cls)  {

        try {
           return objectMapper.readValue(str,cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            log.info("json处理异常", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
