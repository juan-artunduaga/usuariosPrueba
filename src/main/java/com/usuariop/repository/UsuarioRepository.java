package com.usuariop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usuariop.entity.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	@Query(value= "SELECT * FROM usuario u WHERE u.nombre LIKE %:nombre%",nativeQuery =true)
	 Optional <List<Usuario>> findUsuariosByNombre(@Param("nombre") String nombre);
	
	@Query(value="SELECT * FROM usuario u WHERE u.nombre = :nombre ",nativeQuery =true)
	 Optional <Usuario> findUsuarioByNombre(@Param("nombre") String nombre);
}


