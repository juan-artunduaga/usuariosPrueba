package com.usuariop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rol {

	
	@Id
	@Column(name="id_rol")
	private int idRol;
	
	private String nombre;
	
	
	public Rol() {
		
	}

	public Rol(int idRol, String nombre) {
		super();
		this.idRol = idRol;
		this.nombre = nombre;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
