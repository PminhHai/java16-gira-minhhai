package cybersoft.javabackend.java16giraminhhai.role.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java16giraminhhai.role.validation.annotation.UniqueCodeGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class GiraGroupDTO {
	private UUID id;
	
	@Size(min = 5, max = 36, message = "{group.code.size}")
	@UniqueCodeGroup(message = "{group.code.existed}")
	private String code;
	
	@NotBlank(message = "{group.description.notblank}")
	private String description;
}
