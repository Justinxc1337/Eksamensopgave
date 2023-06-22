package com.intec.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Angiver, at det er en Spring Boot-applikation
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		// Starter Spring-applikationen ved at køre klassen "ProjectApplication"
	}

}
