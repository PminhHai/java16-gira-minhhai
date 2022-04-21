package cybersoft.javabackend.java16giraminhhai.security.authorization;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cybersoft.javabackend.java16giraminhhai.role.repository.GiraProgramRepository;
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
	@Autowired
	private GiraProgramRepository programRepository;
	
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
	
	private boolean checkPermission(String programName, String username) {
		List<cybersoft.javabackend.java16giraminhhai.role.model.GiraProgram> programs = programRepository.findProgramByNameAndUsername(programName, username);
		return programs.size() > 0;
	}
	
	private String getCurrentUsername () {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth == null) {
			return null;
		}
		
		if (auth.getPrincipal() instanceof String principal) {
			return principal;
		}
		
		UserDetails currentAuditor = (UserDetails) auth.getPrincipal();
		
		return currentAuditor.getUsername();
	}
}
