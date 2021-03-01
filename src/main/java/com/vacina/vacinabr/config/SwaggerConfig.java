package com.vacina.vacinabr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.vacina.vacinabr.controller";
    private static final String API_TITLE = "Vacine System API";
    private static final String API_DESCRIPTION = "Orange Talents Challenge 2";
    private static final String CONTACT_NAME = "Elon Lima Bezerra";
    private static final String CONTACT_GITHUB = "https://gtihub.com/ElonLima";
    private static final String CONTACT_EMAIL = "elon.blima@gmail.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, responseMessageForPOST())
                .apiInfo(buildApiInfo());
    }

    public ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .contact(new Contact(CONTACT_NAME, CONTACT_EMAIL, CONTACT_GITHUB))
                .build();
    }

    private List<ResponseMessage> responseMessageForPOST(){
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(201)
                    .message("201 created successfully")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(400)
                    .message("400 incorrect information")
                    .build());
        }};
    }
}
