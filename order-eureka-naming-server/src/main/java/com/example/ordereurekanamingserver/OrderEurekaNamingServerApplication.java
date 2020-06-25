package com.example.ordereurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OrderEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderEurekaNamingServerApplication.class, args);
	}

}
