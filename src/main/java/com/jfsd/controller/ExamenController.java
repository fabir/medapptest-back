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

import com.jfsd.model.Examen;
import com.jfsd.service.IExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {
	@Autowired
	private IExamenService examenService;
	
	@GetMapping
	public ResponseEntity<List<Examen>> listar(){
		List<Examen> lista = examenService.listar();
		return new ResponseEntity<List<Examen>>(lista , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Examen> listarPorId(@PathVariable("id") Integer id) {
		Examen obj = examenService.listarPorId(id);
		return new ResponseEntity<Examen>(obj,HttpStatus.OK);
	}
	
    @PostMapping
    public ResponseEntity<Examen> registrar(@Valid @RequestBody Examen pac) {
    	Examen obj = examenService.registrar(pac); 
    	return new ResponseEntity<Examen>(obj,HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Examen> modificar(@Valid @RequestBody Examen pac) {
    	Examen obj = examenService.modificar(pac); 
    	return new ResponseEntity<Examen>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		examenService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
