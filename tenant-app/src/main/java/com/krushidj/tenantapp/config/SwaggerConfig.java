package com.krushidj.tenantapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!production")
public class SwaggerConfig {

    private static final String SECURITY_SCHEME_NAME = "basicAuth";

    //private final String version;

//    public SwaggerConfig(ConfigurationProperties configProperties) {
//        this.version = configProperties.getApi().getVersion();
//    }

    @Bean
    public Docket tenantApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("tenant")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.krushidj.tenantapp.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Tenant Data API")
                .description("Tenant Data Service with Spring Boot and Swagger")
                .contact(new Contact("Anil Ingle", "", "anilingle91@gmail.com"))
                .version("1")
                .build();
    }
}
