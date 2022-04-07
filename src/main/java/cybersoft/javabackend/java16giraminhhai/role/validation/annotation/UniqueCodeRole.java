package cybersoft.javabackend.java16giraminhhai.role.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java16giraminhhai.role.validation.validator.UniqueCodeRoleValidator;

@Constraint(validatedBy = UniqueCodeRoleValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UniqueCodeRole {
	String message() default "Code already used.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
