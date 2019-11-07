package com.revature.charityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CharityTrustApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharityTrustApiApplication.class, args);
	}

}
