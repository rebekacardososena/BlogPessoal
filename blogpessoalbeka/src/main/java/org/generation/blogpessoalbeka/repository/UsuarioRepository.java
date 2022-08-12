package org.generation.blogpessoalbeka.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoalbeka.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsuario(String usuario);
	
	public List<Usuario> findAllByNomeContainigIgonoreCase(@Param("nome")String nome);
	
}
