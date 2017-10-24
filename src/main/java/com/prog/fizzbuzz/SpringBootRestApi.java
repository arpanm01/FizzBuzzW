package com.prog.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.prog.fizzbuzz"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootRestApi {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApi.class, args);
	}
}