package cybersoft.javabackend.java16giraminhhai.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giraminhhai.role.dto.GiraGroupWithRolesDTO;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraGroup;

@Mapper
public interface GiraGroupMapper {
	GiraGroupMapper INSTANCE = Mappers.getMapper(GiraGroupMapper.class);
	
	GiraGroupDTO toDto(GiraGroup model);
	GiraGroup toModel(GiraGroupDTO dto);
	GiraGroupWithRolesDTO toDtoWithRoles(GiraGroup modifiedGroup);
}
