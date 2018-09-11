package com.rw.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rw.payment"))
                .paths(regex("/v1/payment.*"))
                .build()
                .apiInfo(metaData())
                .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("jwt-auth", "Authorization", "Header"))))
                ;
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Сервис оплаты ЭПД на поезда с нумерованными и ненумерованными местами")
                .description("Сервис включает в себя список операций для подготовки к оплате корзины заказов")
                .version("v1")
                .license("")
                .licenseUrl("")
                .build();
    }
}
