package com.AOP.Aspect_Oriented_Proogramming;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public CommandLineRunner run(service paymentService)
    {
        return args ->
        {
            System.out.println("---- TEST CASE 1: Process Payment ----");
            paymentService.processPayment("12345");

            System.out.println("\n---- TEST CASE 2: Cancel Payment ----");
            paymentService.cancelPayment("12345");

            System.out.println("\n---- TEST CASE 3: Throw Exception ----");
            try {
                paymentService.throwException();
            } catch (Exception e) {
                // Exception handled here
            }
        };
    }
}
