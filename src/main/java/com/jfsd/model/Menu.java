package com.jfsd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {

	@Id
	private Integer idMenu;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="url")
	private String url;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="menu_rol",joinColumns= @JoinColumn(name="id_menu",referencedColumnName="idMenu"),inverseJoinColumns = @JoinColumn(name="id_rol", referencedColumnName="idRol"))
    private List<Rol> roles;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
}
