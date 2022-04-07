package cybersoft.javabackend.java16giraminhhai.security.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ExistedUserValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExistedUser {
	String message() default "User is not used.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
