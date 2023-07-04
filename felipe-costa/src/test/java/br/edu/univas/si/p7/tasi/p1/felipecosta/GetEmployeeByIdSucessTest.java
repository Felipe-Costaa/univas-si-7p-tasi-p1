package br.edu.univas.si.p7.tasi.p1.felipecosta;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import br.edu.univas.si.p7.tasi.p1.felipecosta.controller.EmployeeController;
import br.edu.univas.si.p7.tasi.p1.felipecosta.dto.EmployeeDTO;
import br.edu.univas.si.p7.tasi.p1.felipecosta.entities.EmployeeEntity;
import br.edu.univas.si.p7.tasi.p1.felipecosta.service.EmployeeService;

@SpringJUnitConfig
@WebMvcTest(EmployeeController.class)
public class GetEmployeeByIdSucessTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	@Test
	public void testGetEmployeeById_Success() throws Exception {
		// Given
		Long employeeId = 1L;
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employeeId);
		employeeDTO.setCpf("12345678900");
		employeeDTO.setName("John Doe");
		// Set other properties...

		// When
		when(employeeService.findById(employeeId)).thenReturn(employeeDTO);
		mockMvc.perform(get("/employee/{id}", employeeId))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(employeeId));

		// Then
		verify(employeeService).findById(employeeId);
	}
}