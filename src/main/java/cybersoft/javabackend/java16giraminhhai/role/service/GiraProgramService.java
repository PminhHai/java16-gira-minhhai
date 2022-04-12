package cybersoft.javabackend.java16giraminhhai.role.service;

import java.util.List;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraProgramDTO;

public interface GiraProgramService {
	List<GiraProgramDTO> findAllPrograms ();
	GiraProgramDTO save(GiraProgramDTO dto);
}
