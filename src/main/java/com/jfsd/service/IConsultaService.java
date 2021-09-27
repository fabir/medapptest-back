package com.jfsd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfsd.dto.ConsultaListaExamenDTO;
import com.jfsd.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer>{

	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);
	
	Consulta modificarTransaccional(ConsultaListaExamenDTO dto);
	
	Page<Consulta> listarPageable(Pageable pageable);
}
