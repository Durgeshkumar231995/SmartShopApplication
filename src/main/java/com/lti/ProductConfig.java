package com.lti;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class ProductConfig {
	//http://localhost:8084/swagger-ui.html
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.paths(regex("/api.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SmartShop Product Service")
				.description("Sample Documentation Generateed Using SWAGGER2 for our product Rest API")
				.termsOfServiceUrl("https://www.larsentoubro.com")
				.contact("Larsen Tourbo")
				.version("1.0").build();
	}
}
	
	