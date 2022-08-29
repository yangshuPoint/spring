package com.sys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class sysResult {

       private  int status;
       private   String  messgae;
       private  Object data;


       public  static  sysResult success(){
           return new sysResult(200,"服务执行成功",null);
       }

       public  static   sysResult success(String mes ,Object data){
           return  new sysResult(200,mes,data);
       }
       public  static   sysResult success(Object data){
           return  new sysResult(200,"执行成功",data);
       }


       public  static   sysResult fail(){

           return    new sysResult(202,"执行失败",null);
       }
       public  static   sysResult fail(Object data){

           return    new sysResult(202,"执行失败",data);
       }

}
