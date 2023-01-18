package com.dambi.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		
		System.out.print("\033[H\033[2J");
        System.out.flush();
		
		SpringApplication.run(RestapiApplication.class, args);

		
	}

}
