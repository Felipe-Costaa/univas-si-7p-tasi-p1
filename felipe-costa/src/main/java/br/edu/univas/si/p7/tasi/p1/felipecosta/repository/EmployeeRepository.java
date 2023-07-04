package br.edu.univas.si.p7.tasi.p1.felipecosta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si.p7.tasi.p1.felipecosta.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{}