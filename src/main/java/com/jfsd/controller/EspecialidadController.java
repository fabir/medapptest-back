package com.jfsd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfsd.model.Especialidad;
import com.jfsd.service.IEspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
	@Autowired
	private IEspecialidadService especialidadService;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> listar(){
		List<Especialidad> lista = especialidadService.listar();
		return new ResponseEntity<List<Especialidad>>(lista , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> listarPorId(@PathVariable("id") Integer id) {
		Especialidad obj = especialidadService.listarPorId(id);
		return new ResponseEntity<Especialidad>(obj,HttpStatus.OK);
	}
	
    @PostMapping
    public ResponseEntity<Especialidad> registrar(@Valid @RequestBody Especialidad pac) {
    	Especialidad obj = especialidadService.registrar(pac); 
    	return new ResponseEntity<Especialidad>(obj,HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Especialidad> modificar(@Valid @RequestBody Especialidad pac) {
    	Especialidad obj = especialidadService.modificar(pac); 
    	return new ResponseEntity<Especialidad>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		especialidadService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
