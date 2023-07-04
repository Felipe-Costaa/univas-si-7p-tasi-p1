package br.edu.univas.si.p7.tasi.p1.felipecosta.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "CPF", unique = true)
	private String cpf;
	@Column (name = "NOME")
	private String name;
	@Column (name = "HORAS_EXTRA")
	private float extraWorkHours;
	@Column (name = "DATA_ULT_TREINAMENTO")
	private String lastTrainingDate;
	@Column (name = "TOTAL_FOLHA_PAG")
	private float payrollTotalValue;
	@Column (name = "ATIVO")
	private boolean active;

	

}