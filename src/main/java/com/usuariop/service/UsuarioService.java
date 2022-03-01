package com.usuariop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuariop.entity.Usuario;
import com.usuariop.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
}
	
	
	public Optional<Usuario> getUsuarioByName(String nombreUsuario) {
		return usuarioRepository.findUsuarioByNombre(nombreUsuario);
		
	}
	
	public Optional<List<Usuario>> getUsuariosByName(String nombreUsuario) {
		return usuarioRepository.findUsuariosByNombre(nombreUsuario);
		
	}
	
	public Optional<Usuario> getUsuarioByid(int idUsuario) {
		return usuarioRepository.findById(idUsuario);
		
	}
	
	public Usuario createUsuario(Usuario usuario) {
		Optional<Usuario> usuarioOptional =usuarioRepository.findUsuarioByNombre(usuario.getNombre());
		
		if(usuarioOptional.isPresent()) {
			throw new IllegalStateException("El nombre de usuario ya existe");
		}
		else {
			return usuarioRepository.save(usuario);
		}
	}
	
	public Usuario updateUsuario(int usuarioId, Usuario usuario) {
		return usuarioRepository.findById(usuarioId)
		.map(
				usuarioexistente -> {
					Optional<Usuario> usuarioOptional =usuarioRepository.findUsuarioByNombre(usuario.getNombre());
					if(usuarioOptional.isPresent()) throw new IllegalStateException("El nombre de usuario ya existe");	
					usuarioexistente.setNombre(usuario.getNombre());
					usuarioexistente.setActivo(usuario.getActivo());
					usuarioexistente.setIdRol(usuario.getIdRol());
					return usuarioRepository.save(usuarioexistente);
				} ).orElseThrow(()-> new IllegalStateException(
						"El usuario con el id "+usuarioId+" no existe"));
	}

	public boolean deleteUsuario(int usuarioId) {
		return getUsuarioByid(usuarioId)
				.map(usuario ->{
					usuarioRepository.deleteById(usuarioId);
					return true;
				}).orElse(false);
		
		
	}

	
	
	
}
