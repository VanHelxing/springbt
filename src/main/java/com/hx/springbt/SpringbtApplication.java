package com.hx.springbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbtApplication.class, args);
	}
}
