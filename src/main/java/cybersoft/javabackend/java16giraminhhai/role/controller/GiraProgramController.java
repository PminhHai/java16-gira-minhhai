package cybersoft.javabackend.java16giraminhhai.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16giraminhhai.common.util.ResponseHelper;
import cybersoft.javabackend.java16giraminhhai.role.dto.GiraProgramDTO;
import cybersoft.javabackend.java16giraminhhai.role.service.GiraProgramService;
import cybersoft.javabackend.java16giraminhhai.security.authorization.GiraProgram;

@RestController
@RequestMapping("api/v1/programs")
public class GiraProgramController {
	@Autowired
	private GiraProgramService service;
	
	@GiraProgram("findAllPrograms")
	@GetMapping
	public Object findAllPrograms () {
		List<GiraProgramDTO> programs = service.findAllPrograms();
		return ResponseHelper.getResponse(programs, HttpStatus.OK);
	}
	
	@GiraProgram("createdNewProgram")
	@PostMapping
	public Object saveProgram (@RequestBody @Valid GiraProgramDTO dto,
									BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		GiraProgramDTO newProgram = service.save(dto);
		
		return ResponseHelper.getResponse(newProgram, HttpStatus.CREATED);
	}
}
