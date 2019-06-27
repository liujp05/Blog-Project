package com.jpliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 处理流程 为 网页 request <-> controller <-> service <-> dao <-> database
 */
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProjectApplication.class);
	}
	@Bean
	public Docket createRestAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jpliu.controller"))
				.paths(PathSelectors.any()).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}

