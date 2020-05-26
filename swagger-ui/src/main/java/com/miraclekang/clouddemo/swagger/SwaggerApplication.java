package com.miraclekang.clouddemo.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

    @Bean
    public Docket identityApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .groupName("identity")
                .pathMapping("/")
                .globalOperationParameters(parameters())
                .apiInfo(apiInfo("身份认证服务", "V1.0", "身份认证服务"));
    }

    @Bean
    public Docket accessApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .groupName("access")
                .pathMapping("/")
                .globalOperationParameters(parameters())
                .apiInfo(apiInfo("访问控制服务", "V1.0", "访问控制服务"));
    }

    private ApiInfo apiInfo(String name, String version, String description) {
        return new ApiInfoBuilder()
                .title(name)
                .version(version)
                .description(description)
                .build();
    }

    private List<Parameter> parameters() {
        return Collections.singletonList(new ParameterBuilder()
                .name("Authorization")
                .description("Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("Bearer ")
                .allowEmptyValue(true)
                .required(false)
                .build());
    }
}
