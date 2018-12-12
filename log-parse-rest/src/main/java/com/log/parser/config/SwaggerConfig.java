package com.log.parser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    /**
     * This bean is to configure the swagger api documentation.
     * */
    @Bean
    public Docket api() {
        //Configure global required params
        List<Parameter> globalParamList = new ArrayList<>();

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(globalParamList)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .useDefaultResponseMessages(false);


    }

    /**
     * Enable API information title.
     * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Log parser API")
                .build();
    }

    /**
     * This resource handler is to indicate the path where the swagger page is located in the app.
     * */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/swagger/");
        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/swagger/");
    }
}
