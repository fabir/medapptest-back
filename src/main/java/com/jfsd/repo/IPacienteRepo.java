package com.jfsd.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.model.Paciente;

public interface IPacienteRepo extends JpaRepository<Paciente,Integer>{

	Page<Paciente> findAll(Pageable pageable);
	

}
