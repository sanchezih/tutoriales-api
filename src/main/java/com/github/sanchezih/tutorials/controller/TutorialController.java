package com.github.sanchezih.tutorials.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.sanchezih.tutorials.entity.Tutorial;
import com.github.sanchezih.tutorials.repository.TutorialRepository;

/**
 * TutorialController is a RestController which has request mapping methods for
 * RESTful requests such as: getAllTutorials, createTutorial, updateTutorial,
 * deleteTutorial, findByPublished...
 * 
 */
@CrossOrigin(origins = "http://localhost:8081") // @CrossOrigin is for configuring allowed origins.

@RestController // @RestController annotation is used to define a controller and to indicate
				// that the return value of the methods should be be bound to the web response
				// body.

@RequestMapping("/api/v1/tutoriales") // @RequestMapping("/api/v1/tutorials") declares that all Apis’ url in the
										// controller will start with /api/v1/tutorials.

public class TutorialController {

	@Autowired // Se usa @Autowired para inyectar el bean TutorialRepository a la variable
				// local.
	TutorialRepository tutorialRepository;

	/*----------------------------------------------------------------------------*/

	/**
	 * 
	 * @param titulo
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam(required = false) String titulo) {
		try {
			List<Tutorial> tutoriales = new ArrayList<>();

			if (titulo == null) {
				tutoriales = tutorialRepository.findAll();
			} else {
				tutoriales = tutorialRepository.findByTituloContaining(titulo);
			}

			// Si no hay tutoriales para mostrar, se devuelve un codigo 204
			if (tutoriales.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			// Si hay tutoriales para mostrar, se devuelve un codigo 200
			return new ResponseEntity<>(tutoriales, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param _id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id) {

		Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);

		// Si el tutorial existe, se devuelve un codigo 200, en caso contrario, se
		// devuelve 404
		if (tutorialOptional.isPresent()) {
			return new ResponseEntity<>(tutorialOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param tutorial
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Tutorial tutorial) {
		try {
			Tutorial tutorialCreado = tutorialRepository
					.save(new Tutorial(tutorial.getTitulo(), tutorial.getDescripcion(), false));

			return new ResponseEntity<>(tutorialCreado, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param id
	 * @param tutorial
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Tutorial> update(@PathVariable("id") Long id, @RequestBody Tutorial tutorial) {

		Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);

		// Si el tutorial existe, se actualiza todo el recurso
		if (tutorialOptional.isPresent()) {

			Tutorial updatedTutorial = tutorialOptional.get();

			updatedTutorial.setTitulo(tutorial.getTitulo());
			updatedTutorial.setDescripcion(tutorial.getDescripcion());
			updatedTutorial.setPublicado(tutorial.isPublicado());

			return new ResponseEntity<>(tutorialRepository.save(updatedTutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @return
	 */
	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/publicados")
	public ResponseEntity<?> findByPublicado() {
		try {
			List<Tutorial> tutoriales = tutorialRepository.findByPublicado(true);

			if (tutoriales.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutoriales, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}