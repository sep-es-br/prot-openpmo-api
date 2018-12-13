package com.openpmoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.openpmoapi.config.property.OpenpmoApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(OpenpmoApiProperty.class)
public class OpenpmoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenpmoApiApplication.class, args);
		
		
		
		
	}
}
