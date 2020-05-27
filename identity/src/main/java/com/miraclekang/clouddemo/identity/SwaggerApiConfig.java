package com.miraclekang.clouddemo.identity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerApiConfig {

    @Bean
    public Docket identityApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.miraclekang.clouddemo.identity.port.adapter.restful"))
                .build()
                .groupName("identity")
                .pathMapping("/")
                .apiInfo(new ApiInfoBuilder()
                        .title("身份认证服务")
                        .version("V1.0")
                        .description("身份认证服务")
                        .build());
    }
}

