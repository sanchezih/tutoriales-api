package com.github.sanchezih.tutorials.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Tutorial data model class corresponds to entity and table tutorials.
 * 
 */
@Entity // @Entity annotation indicates that the class is a persistent Java class.
@Table(name = "tutorial") // @Table annotation provides the table that maps this entity.
public class Tutorial {

	@Id // @Id annotation is for the primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue annotation is used to define generation
														// strategy for the primary key. GenerationType. IDENTITY: This
														// strategy relies on an auto-incremented database column for
														// primary key generation.
	private long id;

	@Column(name = "title") // @Column annotation is used to define the column in database that maps
							// annotated field.
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;

	/*----------------------------------------------------------------------------*/

	/**
	 * 
	 */
	public Tutorial() {

	}

	/**
	 * 
	 * @param title
	 * @param description
	 * @param published
	 */
	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	/*----------------------------------------------------------------------------*/

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}

}