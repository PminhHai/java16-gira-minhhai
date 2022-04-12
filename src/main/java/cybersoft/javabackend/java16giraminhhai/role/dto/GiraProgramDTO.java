package cybersoft.javabackend.java16giraminhhai.role.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java16giraminhhai.common.model.BaseEntity;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraModule;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraProgram;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraProgramType;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
public class GiraProgramDTO {
	@NotBlank
	private String name;
	
	@NotNull
	private GiraModule module;
	
	@NotNull
	private GiraProgramType type;
	
	@NotBlank
	private String description;
}
