package com.github.sanchezih.tutoriales.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que la clase es una clase Java persistente.
@Table(name = "tutorial") // Nombre de la tabla en la DB.
public class Tutorial {

	@Id // Clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue annotation is used to define generation
														// strategy for the primary key. GenerationType. IDENTITY: This
														// strategy relies on an auto-incremented database column for
														// primary key generation.
	private Long id;

	@Column(name = "title") // Este nombre tendra el atributo en la DB.
	private String titulo;

	@Column(name = "description")
	private String descripcion;

	@Column(name = "published")
	private boolean publicado;

	/*----------------------------------------------------------------------------*/

	public Tutorial() {

	}

	public Tutorial(String titulo, String descripcion, boolean publicado) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.publicado = publicado;
	}

	/*----------------------------------------------------------------------------*/

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

}