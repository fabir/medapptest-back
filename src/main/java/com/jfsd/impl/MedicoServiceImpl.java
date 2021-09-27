package com.jfsd.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Medico;
import com.jfsd.repo.IMedicoRepo;
import com.jfsd.service.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService{

	@Autowired
	private IMedicoRepo repo;
	
	@Override
	public Medico registrar(Medico pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public Medico modificar(Medico pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public List<Medico> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Medico listarPorId(Integer paId) {
		// TODO Auto-generated method stub
		Optional<Medico> pac = repo.findById(paId);
		return pac.isPresent() ? pac.get() : new Medico();
	}

	@Override
	public boolean eliminar(Integer paId) {
		// TODO Auto-generated method stub
		repo.deleteById(paId);
		return true;
	}

}
