package org.generation.blogpessoalbeka.repository;

import java.util.List;

import org.generation.blogpessoalbeka.model.TemaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{
	
	public List<TemaModel> findAllByDescricaoContainingIgnoreCase(@Param ("descricao")String descricao);

}
