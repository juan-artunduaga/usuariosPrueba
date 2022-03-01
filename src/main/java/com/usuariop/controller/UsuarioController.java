package com.usuariop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuariop.entity.Usuario;
import com.usuariop.service.UsuarioService;


@RestController
@RequestMapping(path ="usuario")
public class UsuarioController {
	
	private UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}  
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios(){
		return new ResponseEntity<>(usuarioService.getUsuarios(),HttpStatus.OK);
	}
	
	
	@GetMapping(path="/id/{idUsuario}")
	public ResponseEntity<Usuario> getUsuariosById(@PathVariable("idUsuario") int idUsuario){
	
		return usuarioService.getUsuarioByid(idUsuario)
				.map(usuario -> new ResponseEntity<>(usuario,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@GetMapping(path="{nombreUsuario}")	
	public ResponseEntity<List<Usuario>> getUsuariosByName(@PathVariable("nombreUsuario") String nombreUsuario){
		if(nombreUsuario.trim().isEmpty()) {
			return new ResponseEntity<>(usuarioService.getUsuarios(),HttpStatus.OK);
		}
		return usuarioService.getUsuariosByName(nombreUsuario)
				.map(usuarios -> new ResponseEntity<>(usuarios,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsurio(@RequestBody @Valid Usuario usuario) {
		return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping(path="{usuarioId}")
	public ResponseEntity<Usuario> updateUsuario(
	@RequestBody @Valid Usuario usuario,		
	@PathVariable("usuarioId") int usuarioId){
		return new ResponseEntity<>(usuarioService.updateUsuario(usuarioId, usuario),HttpStatus.OK);
	}	
		
	@DeleteMapping(path="{usuarioId}")
	public ResponseEntity<Object> deleteUsuario (@PathVariable("usuarioId") int usuarioId) {
		if(usuarioService.deleteUsuario(usuarioId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	}
	
	
	
	

