package cybersoft.javabackend.java16giraminhhai.user.service;

import java.util.List;

import cybersoft.javabackend.java16giraminhhai.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giraminhhai.user.dto.GiraUserRolesDTO;
import cybersoft.javabackend.java16giraminhhai.user.dto.GiraUserWithRolesDTO;

public interface GiraUserService {
	List<GiraUserDTO> findAllUser();
	
	GiraUserDTO createNewUser(GiraUserDTO dto);
	
	List<GiraUserRolesDTO> findUserWithRolesByUsername(String username);

	GiraUserWithRolesDTO findUserWithRolesByUsernameUsingJoin(String username);
}
