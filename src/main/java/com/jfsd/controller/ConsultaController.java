package com.jfsd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfsd.dto.ConsultaListaExamenDTO;
import com.jfsd.model.Consulta;
import com.jfsd.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> listar(){
		List<Consulta> lista = consultaService.listar();
		return new ResponseEntity<List<Consulta>>(lista , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) {
		Consulta obj = consultaService.listarPorId(id);
		return new ResponseEntity<Consulta>(obj,HttpStatus.OK);
	}
    
    @PostMapping
    public ResponseEntity<Consulta> registrar(@Valid @RequestBody ConsultaListaExamenDTO dto) {
    	Consulta obj = consultaService.registrarTransaccional(dto); 
    	return new ResponseEntity<Consulta>(obj,HttpStatus.CREATED);
    }
  	
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		consultaService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
    
    @GetMapping("/pageable")
	public ResponseEntity<Page<Consulta>> listarPageable(Pageable pageable) {
		Page<Consulta> pacientes = consultaService.listarPageable(pageable);
		return new ResponseEntity<Page<Consulta>>(pacientes,HttpStatus.OK);
	}
}
