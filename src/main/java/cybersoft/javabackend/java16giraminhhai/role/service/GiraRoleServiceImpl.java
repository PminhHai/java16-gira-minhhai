package cybersoft.javabackend.java16giraminhhai.role.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giraminhhai.role.mapper.GiraRoleMapper;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;
import cybersoft.javabackend.java16giraminhhai.role.repository.GiraRoleRepository;

@Service
public class GiraRoleServiceImpl implements GiraRoleService{
	@Autowired
	private GiraRoleRepository repository;

	@Override
	public List<GiraRoleDTO> findAllDto() {
		List<GiraRole> roles = repository.findAll();
		List<GiraRoleDTO> dtos = roles.stream()
				.map(t -> GiraRoleMapper.INSTANCE.toDto(t))
				.collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public GiraRoleDTO save(GiraRoleDTO dto) {
		// map dto to entity
		GiraRole role = GiraRoleMapper.INSTANCE.toModel(dto);
		GiraRole newRole = repository.save(role);
		
		return GiraRoleMapper.INSTANCE.toDto(newRole);
	}

	@Override
	public GiraRole update(UUID id, @Valid GiraRoleDTO dto) {
		Optional<GiraRole> roleOpt = repository.findById(id);
		
	    if (roleOpt.isEmpty()) {
	    	return null;
	    }
	    
	    GiraRole currentRole = roleOpt.get();
		
	    // check if role code is changed
	    if (!currentRole.getCode().equals(dto.getCode())) {
	    	// check if new role code is used?
	    	Optional<GiraRole> existedRole = repository.findByCode(dto.getCode());
	    	if (existedRole.isPresent())
	    		return null;
	    	
	    	currentRole.setCode(dto.getCode());
	    }
	    
	    currentRole.setDescription(dto.getDescription());
	    
		return repository.save(currentRole);
	}

	@Override
	public GiraRole findById(String id) {
		Optional<GiraRole> roleOpt = repository.findById(UUID.fromString(id));
		
		return roleOpt.orElse(null);
	}


}
