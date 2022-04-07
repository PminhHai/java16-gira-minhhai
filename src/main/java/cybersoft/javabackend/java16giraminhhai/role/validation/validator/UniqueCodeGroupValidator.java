package cybersoft.javabackend.java16giraminhhai.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java16giraminhhai.role.model.GiraGroup;
import cybersoft.javabackend.java16giraminhhai.role.repository.GiraGroupRepository;
import cybersoft.javabackend.java16giraminhhai.role.validation.annotation.UniqueCodeGroup;

public class UniqueCodeGroupValidator implements ConstraintValidator<UniqueCodeGroup, String>{
	
	private String message;
	
	@Autowired
	private GiraGroupRepository repository;
	
	@Override
	public void initialize(UniqueCodeGroup uniqueCode) {
		message = uniqueCode.message(); 
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {
		if(code ==null) {
			return false;
		}
		
		Optional<GiraGroup> groupOtp = repository.findByCode(code);
		
		if(groupOtp.isEmpty()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}
	
}
