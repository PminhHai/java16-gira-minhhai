package cybersoft.javabackend.java16giraminhhai.role.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16giraminhhai.role.model.GiraProgram;

@Repository
public interface GiraProgramRepository extends JpaRepository<GiraProgram, UUID>{
	
	
}
