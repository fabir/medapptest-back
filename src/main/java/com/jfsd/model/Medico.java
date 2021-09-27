package com.jfsd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Integer idMedico;
	
	@Column(name= "nombres",nullable=false)
	private String nombres;
	
	@Column(name= "apellidos",nullable=false)
	private String apellidos;
	
	@Column(name= "CPF",nullable=false)
	private String CPF;
	
	@Column(name= "direccion",nullable=false)
	private String direccion;
	
	@Column(name= "correo",nullable=false)
	private String correo;
	
	@Column(name= "telefono",nullable=false)
	private String telefono;
	
	@Column(name= "sexo",nullable=false)
	private String sexo;
	
	@Column(name= "edad",nullable=false)
	private int edad;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "medico_especialidad", joinColumns = {
			@JoinColumn(name = "id_medico") }, inverseJoinColumns = { @JoinColumn(name = "id_especialidad") })
	private List<Especialidad> especialidades;
	
	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
	public Integer getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

}
