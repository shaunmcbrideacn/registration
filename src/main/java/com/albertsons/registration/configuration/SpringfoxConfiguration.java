package com.albertsons.registration.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringfoxConfiguration {

    @Value("${spring.webflux.base-path}")
    private String contextPath;

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30).pathProvider(new DefaultPathProvider(){
            @Override
            public String getOperationPath(String operationPath){
                return super.getOperationPath(contextPath + operationPath);
            }
        });
    }
}
