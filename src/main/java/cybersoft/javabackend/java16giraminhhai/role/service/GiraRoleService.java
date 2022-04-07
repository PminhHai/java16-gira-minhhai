package cybersoft.javabackend.java16giraminhhai.role.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRoleDTO> findAllDto();
	GiraRoleDTO save(GiraRoleDTO dto);
	GiraRole update(UUID id, @Valid GiraRoleDTO dto);
	GiraRole findById(String id);
}
