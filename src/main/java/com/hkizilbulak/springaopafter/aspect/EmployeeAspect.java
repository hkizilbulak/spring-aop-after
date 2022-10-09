package com.hkizilbulak.springaopafter.aspect;

import com.hkizilbulak.springaopafter.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeAspect {

    @Pointcut(value = "execution(* com.hkizilbulak.springaopafter.service.EmployeeService.*(..))")
    public void logEmployee() {}

    @AfterReturning(pointcut = "logEmployee()", returning = "employee")
    public void afterReturning(JoinPoint joinPoint, Employee employee) {
        System.out.println("After returning method: "+joinPoint.getSignature());
        System.out.println("Employee object: "+ employee);
    }

    @AfterThrowing(pointcut = "logEmployee()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("After throwing method: "+joinPoint.getSignature());
    }

    @After(value = "execution(* com.hkizilbulak.springaopafter.service.EmployeeService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature());
    }


}
