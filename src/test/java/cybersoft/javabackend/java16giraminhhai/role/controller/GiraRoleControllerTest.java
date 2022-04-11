package cybersoft.javabackend.java16giraminhhai.role.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import cybersoft.javabackend.java16giraminhhai.role.model.GiraRole;
import cybersoft.javabackend.java16giraminhhai.role.service.GiraRoleService;

@SpringBootTest
@AutoConfigureMockMvc
public class GiraRoleControllerTest {
	@MockBean
	private GiraRoleService giraRoleService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void mockSecurity () {
		
	}
	
	@Test
	public void shouldReturn403WhenNoUser () throws Exception {
		mockMvc.perform(get("/api/v1/roles"))
			.andDo(print())
			.andExpect(status().isForbidden());
	}
	
//	@WithMockUser(value = "admin")
//	@Test
//	public void shouldReturnEmptyListRoles () throws Exception {
//		when(giraRoleService.findAllDto()).thenReturn(List.of());
//		
//		mockMvc.perform(get("/api/v1/roles"))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andExpect(content().string("[]"));
//	}
	
	@WithMockUser
	@Test
	public void shouldNotFoundRoleWithUnexistedId () throws Exception {
			String roleId = UUID.randomUUID().toString();
			when(giraRoleService.findById(roleId)).thenReturn(null);
			
			mockMvc.perform(get("/api/v1/roles/" + roleId))
					.andDo(print())
					.andExpect(status().isBadRequest())
					.andExpect(content().string(containsString("Role is not existed.")));
	}
	
	@WithMockUser
	@Test
	public void shouldFindRoleSucessfullyWithExistedId () throws Exception {
		String roleId = "61861d02-6b11-4228-adc4-a7f0371697d3";
		GiraRole role = GiraRole.builder()
						.id(UUID.fromString(roleId))
						.code("INTER")
						.description("Intership Role")
						.build();
		
		when(giraRoleService.findById(roleId)).thenReturn(role);
		
		String roleJson = "{\"id\":\"61861d02-6b11-4228-adc4-a7f0371697d3\",\"version\":0,\"createdAt\":null,\"createdBy\":null,\"lastModifiedAt\":null,\"lastModifiedBy\":null,\"code\":\"INTER\",\"description\":\"Intership Role\"}";
		
		mockMvc.perform(get("/api/v1/roles/" + roleId))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(roleJson)));
	}
	
}
