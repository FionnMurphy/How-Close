package com.example.HowClose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class HowCloseApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context =  SpringApplication.run(HowCloseApplication.class, args);
		AsteroidClient asteroidClient = context.getBean(AsteroidClient.class);

		System.out.println("Asteroids: "+ asteroidClient.getAsteroids());
	}

}
