package com.hx.springbt;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbtApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringbtApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
}
