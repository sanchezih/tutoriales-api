package com.github.sanchezih.tutorials.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.github.sanchezih.tutorials.entity.Tutorial;

/**
 * TutorialRepository is an interface that extends JpaRepository for CRUD
 * methods and custom finder methods.
 * 
 * It will be autowired in TutorialController.
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	// Now we can use JpaRepository’s methods: save(), findOne(), findById(),
	// findAll(), count(), delete(), deleteById()… without implementing these
	// methods. We also define custom finder methods:

	// Returns all Tutorials with published having value as input published.
	List<Tutorial> findByPublished(boolean published);

	// Returns all Tutorials which title contains input title.
	List<Tutorial> findByTitleContaining(String title);
}