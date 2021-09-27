package com.jfsd.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jfsd.dto.ConsultaListaExamenDTO;
import com.jfsd.model.Consulta;
import com.jfsd.repo.IConsultaRepo;
import com.jfsd.service.IConsultaService;

@Service
public class ConsultaServiceImpl implements IConsultaService{

	@Autowired
	private IConsultaRepo repo;
	
	@Override
	public Consulta registrar(Consulta obj) {
		obj.getDetalleConsulta().forEach(det -> {
			det.setConsulta(obj);
		});
		return repo.save(obj);
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) {
		dto.getConsulta().getDetalleConsulta().forEach(det ->{
			det.setConsulta(dto.getConsulta());
		});
		repo.save(dto.getConsulta());
		return dto.getConsulta();
	}

	@Transactional
	@Override
	public Consulta modificarTransaccional(ConsultaListaExamenDTO dto) {
		Optional<Consulta> cons = repo.findById(dto.getConsulta().getIdConsulta());
		dto.getConsulta().getDetalleConsulta().forEach(det ->{
			det.setConsulta(dto.getConsulta());
		});
		cons.get().setDetalleConsulta(dto.getConsulta().getDetalleConsulta());
		cons.get().setExamenes(dto.getListaExamen());	
		return dto.getConsulta();
	}
	
	@Override
	public Consulta modificar(Consulta pa) {
		// TODO Auto-generated method stub
		return repo.save(pa);
	}

	@Override
	public List<Consulta> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Consulta listarPorId(Integer paId) {
		// TODO Auto-generated method stub
		Optional<Consulta> pac = repo.findById(paId);
		return pac.isPresent() ? pac.get() : new Consulta();
	}

	@Override
	public boolean eliminar(Integer paId) {
		// TODO Auto-generated method stub
		repo.deleteById(paId);
		return true;
	}

	@Override
	public Page<Consulta> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
