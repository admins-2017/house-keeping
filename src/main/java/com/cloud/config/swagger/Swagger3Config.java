package com.cloud.config.swagger;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * Swagger3 拦截器
 * @author  康东伟
 * @date  2021/1/25
 */
@EnableOpenApi
@Configuration
public class Swagger3Config {

    @Value("${swagger3.enable}")
    private Boolean enableSwagger;
    @Value("${swagger3.title}")
    private String title;
    @Value("${swagger3.description}")
    private String description;
    @Value("${swagger3.authHeaderKey}")
    private String authHeaderKey;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // 是否启用
                .enable(enableSwagger)
                // Swagger UI 头部信息
                .apiInfo(apiInfo())
                // 指定生成文档的接口
                .select()
                //类上有RestController的就进行扫描
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                // 设置安全认证信息
                .securitySchemes(securitySchemes())
                // 设置安全认证应用范围
                .securityContexts(securityContexts());
    }

    /**
     * Swagger UI 头部信息
     * @return Api
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact("康东伟", "http://www.zhikestar.cn/swagger-ui.html", "1067905926@qq.com"))
                // 版本号
                .version("1.0")
                .build();
    }

    /**
     * 权限认证信息(token)
     * @return 集合
     */
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey(authHeaderKey, authHeaderKey, In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }

    /**
     * 设置权限认证应用范围
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference(authHeaderKey,
                                new AuthorizationScope[]{new AuthorizationScope("global", "")})))
                        .build()
        );
    }


}
