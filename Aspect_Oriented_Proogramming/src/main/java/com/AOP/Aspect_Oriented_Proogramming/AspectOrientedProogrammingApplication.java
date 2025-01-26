package com.AOP.Aspect_Oriented_Proogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectOrientedProogrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProogrammingApplication.class, args);
	}

}
