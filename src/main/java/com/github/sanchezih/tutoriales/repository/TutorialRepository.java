package com.github.sanchezih.tutoriales.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.sanchezih.tutoriales.entity.Tutorial;

/**
 * TutorialRepository es una interface que extiende JpaRepository y permite
 * operaciones CRUD y metodos custom
 * 
 * Metodos que se pueden utilizar: save(), findOne(), findById(), findAll(),
 * count(), delete(), deleteById(), entre otros...
 * 
 * Se inyectara en TutorialController.
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	// Metodos custom

	// Retorna todos los publicados. Se debe respetar el nombre del atributo.
	List<Tutorial> findByPublicado(boolean publicado);

	// Retorna todos los que contienen en su titulo lo recibido por parametro.
	List<Tutorial> findByTituloContaining(String titulo);
}