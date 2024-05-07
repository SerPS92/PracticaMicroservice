package com.example.PracticaMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class PracticaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaMicroserviceApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
