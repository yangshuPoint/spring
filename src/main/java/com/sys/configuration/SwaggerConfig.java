package com.sys.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


//    public  Contact DEFAULT_CONTACT = new Contact("", "", "");
//    public  ApiInfo DEFAULT;
//    private  String version;
//    private  String title;
//    private  String description;
//    private  String termsOfServiceUrl;
//    private  String license;
//    private  String licenseUrl;
//    private  Contact contact;
            @Bean
             public Docket createRestApi(){

              return new Docket(DocumentationType.SWAGGER_2)
                 .pathMapping("/")
                         .select()
                         .apis(RequestHandlerSelectors.basePackage("com.sys.controller"))
                          .paths(PathSelectors.any())
                         .build().apiInfo(  new ApiInfoBuilder()
                                 .title("----------->用户接口文档<---------")
                                 .contact(new Contact("杨树", "17332217", "yangshu_open@163.com"))
                                 .description("接口文档详细信息说明")
                                 .version("v1.1")
                                 .license("license-----------")
                                 .licenseUrl("licenseUrl=========================")
                                 .build()).enable(true).groupName("A");


             }





}
