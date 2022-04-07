package cybersoft.javabackend.java16giraminhhai.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;

@Mapper
public interface GiraRoleMapper {
	GiraRoleMapper INSTANCE = Mappers.getMapper(GiraRoleMapper.class);
	
	GiraRole toModel(GiraRoleDTO dto);
	
	GiraRoleDTO toDto(GiraRole model);
}
