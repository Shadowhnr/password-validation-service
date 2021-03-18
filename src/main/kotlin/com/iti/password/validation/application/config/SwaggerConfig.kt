package com.iti.password.validation.application.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig(@Value("password-validation-service") private val serviceName: String) {

    @Autowired
    private lateinit var buildProperties: BuildProperties

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.iti.password.validation.application"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(
                    ApiInfoBuilder()
                            .title(serviceName)
                            .version(buildProperties.version)
                            .description("Password Validation Service API")
                            .build()
            )
}
