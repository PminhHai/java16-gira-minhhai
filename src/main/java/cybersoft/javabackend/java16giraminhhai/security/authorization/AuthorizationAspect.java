package cybersoft.javabackend.java16giraminhhai.security.authorization;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
@Aspect
public class AuthorizationAspect {
	/*
	@Pointcut("within(cybersoft.javabackend.java16giraminhhai.role.controller.*)")
	public void withinPointcut () {};
	
	@Pointcut("execution(public cybersoft.javabackend.java16giraminhhai.role.controller.GiraGroupController.*(..))")
	public void executionPointcut () {};
	
	@Pointcut("@annotation(cybersoft.javabackend.java16giraminhhai.security.authorization.GiraProgram)")
	public void annotationPointcut () {};
	
	@Before("annotationPointcut()")
	public void beforeAdvice (JoinPoint point) {
		
	}
	
	@After("withinPointcut()")
	public void afterAdvice (JoinPoint point) {
		
	}
	
	@Around("executionPointcut()")
	public void aroundAdvice (ProceedingJoinPoint point) {
		
	}
	*/
	@Before("@annotation(giraProgram)")
	public void programAuthorizer (GiraProgram giraProgram) {
		log.info("===============================================================");
		log.info("AOP: Gira Program " + giraProgram.value() + " has been called.");
		log.info("===============================================================");
	}
	
	@After("@annotation(giraProgram)")
	public void afterAuthorizer (GiraProgram giraProgram) {
		log.info("===============================================================");
		log.info("AOP: Gira Program " + giraProgram.value() + " has been ended.");
		log.info("===============================================================");
	}
}
