package de.yfu.intranet.methods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


/**
 * @Author Alex Senger <alexander.senger@yfu-deutschland.de>
 *
 * Created alongside this tutorial:
 * http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("de.yfu.intranet.methods.api"))
//                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/**"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "YFU Method Service REST API",
                "",
                "0.0.1",
                "Terms of service",
                new Contact("Alex Senger", "intranet.yfu.de", "alexander.senger@yfu-deutschland.de"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
