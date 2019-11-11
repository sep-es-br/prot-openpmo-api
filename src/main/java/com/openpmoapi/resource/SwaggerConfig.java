package com.openpmoapi.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
* Type here a brief description of the class.<br>
*
*	This class makes it possible to use and configure swagger<br>
*	The Swagger it's used to make documentation<br>
*	In this class has already another method that turn's <br>
*	possible the configuration of the <code>html</code> of the swagger 
*	
* @author lucas.regio  
* @since 2018-11-12
* 
*/
@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.openpmoapi.resource"))
                .paths(regex("/api.*"))
                .build();
//                .apiInfo(metaInfo());
    }

//    private ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "",
//                "",
//                "",
//                "",
//                new Contact("", "",
//                        ""),
//                "",
//                ""
//        );
//
//        return apiInfo;
//    }
	
	
	
	
}