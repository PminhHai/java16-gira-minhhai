package cybersoft.javabackend.java16giraminhhai.role.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16giraminhhai.role.dto.GiraGroupWithRolesDTO;
import cybersoft.javabackend.java16giraminhhai.role.model.GiraGroup;

@Repository
public interface GiraGroupRepository extends JpaRepository<GiraGroup, UUID> {

	Optional<GiraGroup> findByCode(String code);
	
	@Query("SELECT g FROM GiraGroup g JOIN g.roles WHERE g.id = ?1")
	GiraGroup findGroupWithRoleByGroupId(UUID groupId);
	
	
}
