package br.edu.univas.si.p7.tasi.p1.felipecosta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.univas.si.p7.tasi.p1.felipecosta.controller.EmployeeController;
import br.edu.univas.si.p7.tasi.p1.felipecosta.dto.EmployeeDTO;
import br.edu.univas.si.p7.tasi.p1.felipecosta.service.EmployeeService;

@SpringJUnitConfig
@WebMvcTest(EmployeeController.class)
public class CreateEmployee_Success_Test {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	@Test
	public void testCreateEmployee_Success() throws Exception {
	    EmployeeDTO employeeDTO = new EmployeeDTO();
	    employeeDTO.setId(1L);
	    employeeDTO.setCpf("12345678900");
	    employeeDTO.setName("John Doe");

	    doNothing().when(employeeService).createEmployee(any(EmployeeDTO.class));
	    mockMvc.perform(post("/employee")
	            .content(asJsonString(employeeDTO))
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isCreated());

	    verify(employeeService).createEmployee(any(EmployeeDTO.class));
	}
	private static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}