package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2//adding swagger to use And explore the ui service 
public class EcomeraceBackendProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomeraceBackendProjectApplication.class, args);
	}

}
