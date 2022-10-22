package com.example.HowClose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Configuration
@EnableScheduling
public class HowCloseApplication {
	private static AsteroidClient asteroidClient;

	public static void main(String[] args) {

		ConfigurableApplicationContext context =  SpringApplication.run(HowCloseApplication.class);
		asteroidClient = context.getBean(AsteroidClient.class);

		updateAsteroids();
	}
	@Scheduled(cron = "0 0 1 * * *")
	public static void updateAsteroids(){
		try{
			System.out.println("Asteroids: "+ asteroidClient.getAsteroids());
		}catch (Exception e){
			System.out.println("Failed to get asteroids");
		}
	}

}
