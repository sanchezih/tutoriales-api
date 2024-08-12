package com.github.sanchezih.tutorials.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.github.sanchezih.tutorials.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	
	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String title);
}