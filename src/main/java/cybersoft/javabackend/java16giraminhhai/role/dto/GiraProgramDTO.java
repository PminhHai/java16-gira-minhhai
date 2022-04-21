package cybersoft.javabackend.java16giraminhhai.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.java16giraminhhai.role.model.GiraModule;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraProgramType;
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
