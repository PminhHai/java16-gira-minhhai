package cybersoft.javabackend.java16giraminhhai.user.dto;

import java.util.List;
import java.util.UUID;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraRoleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GiraUserWithRolesDTO {
	private UUID id;
	private String username;
	private String displayName;
	private String email;
	private List<GiraRoleDTO> roles;
}
