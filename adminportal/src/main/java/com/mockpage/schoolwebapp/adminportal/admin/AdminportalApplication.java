package com.mockpage.schoolwebapp.adminportal.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminportalApplication.class, args);
	}
}