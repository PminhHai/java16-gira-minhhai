package cybersoft.javabackend.java16giraminhhai.role.dto;

import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GiraGroupWithRolesDTO {
	private UUID id;
	
	private String code;
	
	private String description;
	
	Set<GiraRoleDTO> roles;
}
