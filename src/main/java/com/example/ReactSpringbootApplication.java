package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
// @EnableSwagger2
public class ReactSpringbootApplication {

	@Value("${origins.urls}")
	private String originsUrls;

	@Value("${origins.allowed.methods}")
	private String allowedMethods;

	@Value("${max.age.seconds}")
	private long maxAgeSeconds;

	@Value("${api.mapping.url}")
	private String apiMappingUrl;
	public static void main(String[] args) {
		SpringApplication.run(ReactSpringbootApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping(apiMappingUrl)
				.maxAge(maxAgeSeconds)
				.allowedMethods(allowedMethods.split(","))
				.allowedOrigins(originsUrls.split(","));
			}
		};
	}

	// @Bean
	// public Docket api() {
	// return new Docket(DocumentationType.SWAGGER_2)
	// .select()
	// .apis((Predicate<RequestHandler>)
	// RequestHandlerSelectors.basePackage("com.example.demospringboot"))
	// .build();
	// }

}
