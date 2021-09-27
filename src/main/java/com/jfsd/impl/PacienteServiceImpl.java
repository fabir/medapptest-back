package com.jfsd.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jfsd.model.Paciente;
import com.jfsd.repo.IPacienteRepo;
import com.jfsd.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo repo;
	
	@Override
	public Paciente registrar(Paciente pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public Paciente modificar(Paciente pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Paciente listarPorId(Integer paId) {
		// TODO Auto-generated method stub
		Optional<Paciente> pac = repo.findById(paId);
		return pac.isPresent() ? pac.get() : new Paciente();
	}

	@Override
	public boolean eliminar(Integer paId) {
		// TODO Auto-generated method stub
		repo.deleteById(paId);
		return true;
	}

	@Override
	public Page<Paciente> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
