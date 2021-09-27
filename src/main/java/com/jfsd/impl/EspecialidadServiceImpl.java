package com.jfsd.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Especialidad;
import com.jfsd.repo.IEspecialidadRepo;
import com.jfsd.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl  implements IEspecialidadService{
	
	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	public Especialidad registrar(Especialidad pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public Especialidad modificar(Especialidad pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public List<Especialidad> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Especialidad listarPorId(Integer paId) {
		// TODO Auto-generated method stub
		Optional<Especialidad> pac = repo.findById(paId);
		return pac.isPresent() ? pac.get() : new Especialidad();
	}

	@Override
	public boolean eliminar(Integer paId) {
		// TODO Auto-generated method stub
		repo.deleteById(paId);
		return true;
	}
}
