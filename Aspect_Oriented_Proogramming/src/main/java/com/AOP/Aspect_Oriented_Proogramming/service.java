package com.AOP.Aspect_Oriented_Proogramming;
import org.springframework.stereotype.Service;

@Service
public class service
{
        public  String processPayment(String accountId)
        {
            System.out.println("Processing payment for account: " + accountId);
            return "Payment processed for " + accountId;
        }

        public  void cancelPayment(String accountId)
        {
            System.out.println("Payment canceled for account: " + accountId);
        }

        public  void throwException()
        {
            throw new RuntimeException("An error occurred during payment!");
        }
}

