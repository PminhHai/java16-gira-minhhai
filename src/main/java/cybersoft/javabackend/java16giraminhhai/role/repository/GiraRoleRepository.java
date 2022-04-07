package cybersoft.javabackend.java16giraminhhai.role.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;

@Repository
public interface GiraRoleRepository extends JpaRepository<GiraRole, UUID> {

	Optional<GiraRole> findByCode(String code);

}
