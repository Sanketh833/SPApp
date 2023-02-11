package com.ihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IhubRoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IhubRoomsApplication.class, args);
	}

}
