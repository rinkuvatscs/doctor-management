package com.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.medical" , "com.location"})
public class DoctorManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorManagementApplication.class, args);
	}
}
