package br.edu.univas.si.p7.tasi.p1.felipecosta;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import br.edu.univas.si.p7.tasi.p1.felipecosta.controller.EmployeeController;
import br.edu.univas.si.p7.tasi.p1.felipecosta.service.EmployeeService;

@SpringJUnitConfig
@WebMvcTest(EmployeeController.class)
public class GetEmployeeByIdNotFoundTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	@Test
	public void testGetEmployeeById_NotFound() throws Exception {
		// Given
		Long employeeId = 1L;

		// When
		when(employeeService.findById(employeeId)).thenReturn(null);
		mockMvc.perform(get("/employee/{id}", employeeId))
				.andExpect(status().isNotFound());

		// Then
		verify(employeeService).findById(employeeId);
	}
}