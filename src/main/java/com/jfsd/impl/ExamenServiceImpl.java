package com.jfsd.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Examen;
import com.jfsd.repo.IExamenRepo;
import com.jfsd.service.IExamenService;

@Service
public class ExamenServiceImpl implements IExamenService{
	@Autowired
	private IExamenRepo repo;
	
	@Override
	public Examen registrar(Examen pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public Examen modificar(Examen pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public List<Examen> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Examen listarPorId(Integer paId) {
		// TODO Auto-generated method stub
		Optional<Examen> pac = repo.findById(paId);
		return pac.isPresent() ? pac.get() : new Examen();
	}

	@Override
	public boolean eliminar(Integer paId) {
		// TODO Auto-generated method stub
		repo.deleteById(paId);
		return true;
	}
}
