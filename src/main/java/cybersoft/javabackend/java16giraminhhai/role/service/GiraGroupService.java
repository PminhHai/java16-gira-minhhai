package cybersoft.javabackend.java16giraminhhai.role.service;

import java.util.List;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giraminhhai.role.dto.GiraGroupWithRolesDTO;

public interface GiraGroupService {
	List<GiraGroupDTO> findAllDto();
	GiraGroupDTO createNewGroup(GiraGroupDTO dto);
	GiraGroupWithRolesDTO addRole(String groupId, String roleId);
	GiraGroupWithRolesDTO removeRole(String groupId, String roleId);
	GiraGroupWithRolesDTO findById(String groupId);
	
}
