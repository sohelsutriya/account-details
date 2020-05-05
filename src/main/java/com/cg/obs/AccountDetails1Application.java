package com.cg.obs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountDetails1Application {

	public static void main(String[] args) {
		SpringApplication.run(AccountDetails1Application.class, args);
	}

}
