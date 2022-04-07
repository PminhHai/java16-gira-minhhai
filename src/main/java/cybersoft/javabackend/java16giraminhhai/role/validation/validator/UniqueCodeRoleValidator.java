package cybersoft.javabackend.java16giraminhhai.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;
import cybersoft.javabackend.java16giraminhhai.role.repository.GiraRoleRepository;
import cybersoft.javabackend.java16giraminhhai.role.validation.annotation.UniqueCodeRole;

public class UniqueCodeRoleValidator implements ConstraintValidator<UniqueCodeRole, String>{
	private String message;
	
	@Autowired
	private GiraRoleRepository repository;
	
	@Override
	public void initialize(UniqueCodeRole uniqueCode) {
		message = uniqueCode.message();
		
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {
		if(code == null) {
			return false;
		}
		
		Optional<GiraRole> roleOpt = repository.findByCode(code);
		
		if(roleOpt.isEmpty()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}	
}
