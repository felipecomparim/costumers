package br.com.fcc.tech.costumers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDoc() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.fcc.tech.costumers")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API de Cadastros da Clientes").description("API de Cadastros da Clientes")
				.license("").licenseUrl("http://unlicense.org").termsOfServiceUrl("www.fcc-tech.com.br")
				.version("0.0.1-SNAPSHOT").contact(new Contact("Software Factory", "www.fcc-tech.com.br", "")).build();
	}
}
