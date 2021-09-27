package com.jfsd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examen")
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdExamen;
	
	@Column(name="nombre",nullable = false, length = 50)
	private String nombre;
	
	@Column(name="descripcion",nullable = true, length = 150)
	private String descripcion;

	public Integer getIdExamen() {
		return IdExamen;
	}

	public void setIdExamen(Integer idExamen) {
		IdExamen = idExamen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdExamen == null) ? 0 : IdExamen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Examen other = (Examen) obj;
		if (IdExamen == null) {
			if (other.IdExamen != null)
				return false;
		} else if (!IdExamen.equals(other.IdExamen))
			return false;
		return true;
	}
	
	
}
