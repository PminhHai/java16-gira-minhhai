package cybersoft.javabackend.java16giraminhhai.security.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java16giraminhhai.user.model.GiraUser;
import cybersoft.javabackend.java16giraminhhai.user.repository.GiraUserRepository;

public class ExistedUserValidation implements ConstraintValidator<ExistedUser, String>{
	private String message;
	
	@Autowired
	private GiraUserRepository repository;
	
	@Override
	public void initialize(ExistedUser existedUser) {
		message = existedUser.message();
		
		
	}
	
	@Override
	public boolean isValid(String user, ConstraintValidatorContext context) {
		if(user == null) {
			return false;
		}
		
		Optional<GiraUser> userOpt = repository.findByUsername(user);
		
		if(userOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}
}
