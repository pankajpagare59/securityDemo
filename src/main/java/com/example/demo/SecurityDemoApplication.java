package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
		
		
	}
	
	@RequestMapping("/xyz")
	public String greetings()
	{
	
		return" Spring Boot with Spring Security!";
 	}
	@RequestMapping("/pqr")
	public String print()
	{
	
		return" Spring Security!";
 	}
	


}
