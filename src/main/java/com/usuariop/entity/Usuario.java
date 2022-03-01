package com.usuariop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	private int idUsuario;
	
	@NotBlank
	@Column(name="id_rol")
	private int idRol;

	@NotBlank
	@Size(min = 3,max = 40,message = "El nombre debe tener entre 3 y 40 caracteres")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_rol", insertable = false, updatable = false)
	private Rol rol;
	
	
	@NotBlank(message = "El activo no debe ser nulo")
	private char activo;
	
	public Usuario() {
		
	}

	public Usuario(int idUsuario, @NotBlank int idRol,
			@NotBlank @Size(min = 3, max = 40, message = "El nombre debe tener entre 3 y 40 caracteres") String nombre,
			Rol rol, @NotBlank(message = "El activo no debe ser nulo") char activo) {
		super();
		this.idUsuario = idUsuario;
		this.idRol = idRol;
		this.nombre = nombre;
		this.rol = rol;
		this.activo = activo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", idRol=" + idRol + ", nombre=" + nombre + ", rol=" + rol
				+ ", activo=" + activo + "]";
	}

	
	
	
	

}
