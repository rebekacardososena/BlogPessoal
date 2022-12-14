package org.generation.blogpessoalbeka.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogpessoalbeka.model.PostagemModel;
import org.generation.blogpessoalbeka.repository.PostagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> GetById(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
}
	
	@PostMapping
	public ResponseEntity<PostagemModel> post (@Valid @RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));		
	}
	@PutMapping
	public ResponseEntity<PostagemModel> put (@Valid @RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		postagemRepository.deleteById(id);
	}
	
}


