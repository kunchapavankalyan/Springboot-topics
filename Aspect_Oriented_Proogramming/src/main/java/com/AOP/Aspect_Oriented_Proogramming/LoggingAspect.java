package com.AOP.Aspect_Oriented_Proogramming;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;



import org.springframework.stereotype.Component;

// Marks this class as an Aspect to be used by Spring AOP
@Aspect
@Component
public class LoggingAspect
{
    public LoggingAspect()
    {
        System.out.println("LoggingAspect initialized!");
    }

    // 1. Before Advice: Executes before the target method
    @Before("execution(* com.AOP.Aspect_Oriented_Proogramming.service.processPayment(..))")

    public void logBefore()
    {
        // This message will be logged before the method "processPayment" is called
        System.out.println("[Before] PaymentService: Method is about to execute.");
    }

    // 2. After Advice: Executes after the target method, regardless of its outcome (success or exception)
    @After("execution(* com.AOP.Aspect_Oriented_Proogramming.service.processPayment(..))")
    public void logAfter()
    {
        // This message will be logged after the method "processPayment" has executed
        System.out.println("[After] PaymentService: Method has executed.");
    }

    // 3. After Returning Advice: Executes after the target method successfully returns a value
    @AfterReturning(
            pointcut = "execution(* com.AOP.Aspect_Oriented_Proogramming.service.processPayment(..))",
            returning = "result" // Captures the return value of the method
    )
    public void logAfterReturning(Object result)
    {
        // Logs the return value of the method "processPayment"
        System.out.println("[AfterReturning] PaymentService: Method returned: " + result);
    }

    // 4. After Throwing Advice: Executes if the target method throws an exception
    @AfterThrowing(
            pointcut = "execution(* com.AOP.Aspect_Oriented_Proogramming.service.processPayment(..))",
            throwing = "exception" // Captures the exception thrown by the method
    )
    public void logAfterThrowing(Exception exception)
    {
        // Logs the exception thrown by the method "throwException"
        System.out.println("[AfterThrowing] Exception thrown: " + exception.getMessage());
    }

    // 5. Around Advice: Wraps the target method to execute custom behavior before and after the method
    @Around("execution(* com.AOP.Aspect_Oriented_Proogramming.service.processPayment(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        // Logs before the method is executed
        System.out.println("[Around] Before method: " + joinPoint.getSignature());
        // Executes the target method
        Object result = joinPoint.proceed();
        // Logs after the method has executed
        System.out.println("[Around] After method: " + joinPoint.getSignature());
        return result;
    }

    // 6. Defining a reusable Pointcut: Matches all methods in the "PaymentService" class
    @Pointcut("execution(* com.AOP.Aspect_Oriented_Proogramming.service.processPayment(..))")
    public void allPaymentServiceMethods()
    {
        // This method is a placeholder for the reusable pointcut
    }

    // Applying the reusable Pointcut: Logs a message before any method in "PaymentService" is executed
    @Before("allPaymentServiceMethods()")
    public void logForAllMethods()
    {
        // Logs whenever any method in the "PaymentService" is called
        System.out.println("[Pointcut] Executing method in PaymentService.");
    }
}
