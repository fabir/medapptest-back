package com.jfsd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfsd.model.Medico;
import com.jfsd.service.IMedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	@Autowired
	private IMedicoService medicoService;
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Medico>> listar(){
		List<Medico> lista = medicoService.listar();
		return new ResponseEntity<List<Medico>>(lista , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id) {
		Medico obj = medicoService.listarPorId(id);
		return new ResponseEntity<Medico>(obj,HttpStatus.OK);
	}
	
    @PostMapping
    public ResponseEntity<Medico> registrar(@Valid @RequestBody Medico pac) {
    	Medico obj = medicoService.registrar(pac); 
    	return new ResponseEntity<Medico>(obj,HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Medico> modificar(@Valid @RequestBody Medico pac) {
    	Medico obj = medicoService.modificar(pac); 
    	return new ResponseEntity<Medico>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		medicoService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
