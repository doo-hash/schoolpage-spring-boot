package com.mockpage.schoolpageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SchoolpageserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolpageserviceApplication.class, args);
	}

}
