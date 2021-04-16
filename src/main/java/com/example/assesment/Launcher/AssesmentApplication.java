package com.example.assesment.Launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = "com.example.assesment")
public class AssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssesmentApplication.class, args);
	}

}
