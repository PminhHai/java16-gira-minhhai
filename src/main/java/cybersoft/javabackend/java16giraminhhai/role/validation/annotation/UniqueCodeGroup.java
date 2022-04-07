package cybersoft.javabackend.java16giraminhhai.role.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java16giraminhhai.role.validation.validator.UniqueCodeGroupValidator;

@Constraint(validatedBy = UniqueCodeGroupValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueCodeGroup {
	String message() default "Code already used.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
