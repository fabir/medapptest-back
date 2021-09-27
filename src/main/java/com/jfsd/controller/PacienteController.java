package com.jfsd.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jfsd.model.Paciente;
import com.jfsd.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> lista = pacienteService.listar();
		return new ResponseEntity<List<Paciente>>(lista , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) {
		Paciente obj = pacienteService.listarPorId(id);
		return new ResponseEntity<Paciente>(obj,HttpStatus.OK);
	}
	
	//Para utilizar HATEOAS
	/*@GetMapping("/hateoas/{id}")
	public EntityModel<Paciente> listarPorIdHateoas(@PathVariable("id") Integer id) {
		Paciente obj = pacienteService.listarPorId(id);
		EntityModel<Paciente> recurso = new EntityModel<Paciente>(obj);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		recurso.add(linkTo.withRel("paciente-resource"));
		//return new ResponseEntity<Paciente>(obj,HttpStatus.OK);
		return recurso;
	}*/
	
    @PostMapping
    public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente pac) {
    	Paciente obj = pacienteService.registrar(pac);
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
    	return ResponseEntity.created(location).build();
    }
    
    @PutMapping
    public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente pac) {
    	Paciente obj = pacienteService.modificar(pac); 
    	return new ResponseEntity<Paciente>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		pacienteService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
    
	@GetMapping("/pageable")
	public ResponseEntity<Page<Paciente>> listarPageable(Pageable pageable) {
		Page<Paciente> pacientes = pacienteService.listarPageable(pageable);
		return new ResponseEntity<Page<Paciente>>(pacientes,HttpStatus.OK);
	}
}
