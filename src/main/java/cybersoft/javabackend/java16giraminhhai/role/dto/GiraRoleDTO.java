package cybersoft.javabackend.java16giraminhhai.role.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java16giraminhhai.role.validation.annotation.UniqueCodeRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiraRoleDTO {
	private UUID id;
	
	@Size(min = 5, max = 100, message = "{group.code.size}")
	@UniqueCodeRole(message = "{role.code.existed}")
	private String code;
	
	@NotBlank(message = "{group.description.notblank}")
	private String description;
}
