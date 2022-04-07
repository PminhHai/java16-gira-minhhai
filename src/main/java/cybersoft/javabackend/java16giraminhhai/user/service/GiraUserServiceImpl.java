package cybersoft.javabackend.java16giraminhhai.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraGroupWithRolesDTO;
import cybersoft.javabackend.java16giraminhhai.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giraminhhai.role.mapper.GiraRoleMapper;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraGroup;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;
import cybersoft.javabackend.java16giraminhhai.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giraminhhai.user.dto.GiraUserRolesDTO;
import cybersoft.javabackend.java16giraminhhai.user.dto.GiraUserWithRolesDTO;
import cybersoft.javabackend.java16giraminhhai.user.mapper.GiraUserMapper;
import cybersoft.javabackend.java16giraminhhai.user.model.GiraUser;
import cybersoft.javabackend.java16giraminhhai.user.repository.GiraUserRepository;

@Service
public class GiraUserServiceImpl implements GiraUserService {
	@Autowired
	private GiraUserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public List<GiraUserDTO> findAllUser() {
		List<GiraUser> users = repository.findAll();
		List<GiraUserDTO> dtos = users.stream()
						.map(t -> GiraUserMapper.INSTANCE.toDTO(t))
						.collect(Collectors.toList());
		return dtos;
	}

	@Override
	public GiraUserDTO createNewUser(GiraUserDTO dto) {
		GiraUser user = GiraUserMapper.INSTANCE.toModel(dto);
		
		// encode password before save
		user.setPassword(encoder.encode(dto.getPassword()));
		
		GiraUser newUser = repository.save(user);
		
		newUser.setPassword("");
		
		return GiraUserMapper.INSTANCE.toDTO(newUser);
	}

	@Override
	public List<GiraUserRolesDTO> findUserWithRolesByUsername(String username) {
		return repository.findUserWithRolesByUsername(username);
	}

	@Override
	public GiraUserWithRolesDTO findUserWithRolesByUsernameUsingJoin(String username) {
		GiraUser user = repository.findUserRolesByUsernameEntityGraph(username);
		
		if(user == null) {
			return null;
		}
		
		return GiraUserWithRolesDTO.builder()
						.id(user.getId())
						.username(user.getUsername())
						.displayName(user.getDisplayName())
						.email(user.getEmail())
						.roles(getRolesFromUser(user))
						.build();
	}

	protected List<GiraRoleDTO> getRolesFromUser(GiraUser user) {
		List<GiraRoleDTO> roles = new ArrayList<GiraRoleDTO>();
		
		for(GiraGroup group : user.getGroups()) {
			group.getRoles().forEach((role) -> {
				if (isRoleExisted(roles, role))
					return;
				
				roles.add(GiraRoleMapper.INSTANCE.toDto(role));
			});
		}
		return roles;
	}

	protected boolean isRoleExisted(List<GiraRoleDTO> roles, GiraRole role) {
		for (GiraRoleDTO dto : roles)
			if (dto.getCode().equals(role.getCode()))
				return true;
		
		return false;
	}

}
