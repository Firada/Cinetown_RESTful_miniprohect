package com.execinema.restfulapi_cinetown.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
//Siccome impostato da SpringBoot, se non si vede Swagger estendere WebMvcConfigurationSupport
public class SwaggerConfig /*extends WebMvcConfigurationSupport*/ {

    //url: localhost:8080/swagger-ui.html

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().pathMapping("/")
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){

        //importare Contact(springfox.documentation.service)
        Contact contact = new Contact("Lorenzo Scillone", "TBD",
                "no email yet");

        return new ApiInfo(
                "Cinetown RESTful API project",
                "It's a cinetown project.",
                "1.0",
                "Terms of Service: tbd",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

    //importare il seguente metodo da WebMvcConfigurationSupport e configurarlo se non si vedesse Swagger tramite l'url di linea 20
    /*    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath/META-INF/resources/webjars/");
    }*/


}
