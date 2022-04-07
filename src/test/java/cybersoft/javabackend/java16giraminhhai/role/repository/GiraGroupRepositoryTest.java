package cybersoft.javabackend.java16giraminhhai.role.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class GiraGroupRepositoryTest {
	
	@Autowired
	private GiraGroupRepository repository;
	
	@BeforeAll
	public void setup () {
		
	}
	
	@Test
	public void shouldFetchGroupWithRoles () {
		
		assertDoesNotThrow( () -> {
			repository.findGroupWithRoleByGroupId(UUID.fromString("bd8eabb7-d093-4317-9cb3-f1c607c41081"));
		});
		
	}
}
