package com.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HealthApplication.class);
		app.addInitializers(new EnvironmentInitializer());
		app.run(args);
	}

 
   
}
