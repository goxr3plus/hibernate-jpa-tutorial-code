package com.goxr3plus.jpa.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.goxr3plus.jpa.hibernate.enums.Rating;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private Rating rating;

	@NotNull
	@Column(nullable = false)
	private String description;

	@ManyToOne
	private Course course;

	public Review() {

	}

	public Review(final Rating rating, @NotNull final String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(final Rating rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(final Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}

}
