package dev.gokhana.restapibestpractices.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    // Url: http://localhost:8080/swagger-ui/index.html
    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("dev.gokhana"))
        .paths(PathSelectors.any())
        .build()


    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("User Service")
            .description("User Management Service Api")
            .contact(Contact("Gokhan Ayrancioglu", "https://gokhana.dev", ""))
            .license("Apache 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0")
            .build()
    }
}