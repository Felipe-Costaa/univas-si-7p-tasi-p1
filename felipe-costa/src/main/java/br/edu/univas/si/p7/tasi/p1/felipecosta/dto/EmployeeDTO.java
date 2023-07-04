package br.edu.univas.si.p7.tasi.p1.felipecosta.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.univas.si.p7.tasi.p1.felipecosta.entities.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	private long id;
	private String cpf;
	private String name;
	private float extraWorkHours;
	private String lastTrainingDate;
	private float payrollTotalValue;
	@JsonIgnore
	private boolean active;

	public EmployeeDTO(EmployeeEntity employee) {
		this.id = employee.getId();
		this.cpf = employee.getCpf();
		this.name = employee.getName();
		this.extraWorkHours = employee.getExtraWorkHours();
		this.lastTrainingDate = employee.getLastTrainingDate();
		this.payrollTotalValue = employee.getPayrollTotalValue();
		this.active = employee.isActive();
	}
	
}