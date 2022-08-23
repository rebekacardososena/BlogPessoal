package org.generation.blogpessoalbeka.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = " tb_postagem")
public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O Atributo título é Obrigatório!")
	@Size(min = 5, max = 100, message = "O Atributo título dvee conter no minimo 5 e no máximo 100 caracteres.")
	private String titulo;
	
	@NotNull(message = "O Atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O Atributo texto deve ter conter no mínimo 10 e nomáximo 1000 caracteres.")
	private String texto;
	
	@UpdateTimestamp
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private UsuarioModel usuario;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TemaModel getTema() {
		return tema;
	}
	public void setTema(TemaModel tema) {
		this.tema = tema;
	}
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
}
