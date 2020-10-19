package com.qfedu.kataba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description swagger配置类
 * @createTime 2020/10/19 17:02
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder().title("片场项目的在线接口文档").
                contact(new Contact("Java2004", "http://baidu.com", "java2004@163.com"))
                .version("0.1").description("这是一个在线接口文档，可以直接查看接口的信息并且可以实现接口的测试")
                .build();
    }

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(createApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.qfedu.kataba.controller")).
                        build();
    }
}
