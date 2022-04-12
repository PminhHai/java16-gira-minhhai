package cybersoft.javabackend.java16giraminhhai.role.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraProgramDTO;
import cybersoft.javabackend.java16giraminhhai.role.mapper.GiraProgramMapper;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraProgram;
import cybersoft.javabackend.java16giraminhhai.role.repository.GiraProgramRepository;

@Service
public class GiraProgramServiceImpl implements GiraProgramService{
	@Autowired
	private GiraProgramRepository repository;
	
	@Override
	public List<GiraProgramDTO> findAllPrograms() {
		List<GiraProgram> programs = repository.findAll();
		List<GiraProgramDTO> dtoprograms = programs.stream()
				.map(t -> GiraProgramMapper.INSTANCE.toDTO(t))
				.collect(Collectors.toList());
		
 		return dtoprograms;
	}

	@Override
	public GiraProgramDTO save(GiraProgramDTO dto) {
		GiraProgram model = GiraProgramMapper.INSTANCE.toModel(dto);
		
		GiraProgram createdProgram = repository.save(model);
		
		return GiraProgramMapper.INSTANCE.toDTO(createdProgram);
	}

}
