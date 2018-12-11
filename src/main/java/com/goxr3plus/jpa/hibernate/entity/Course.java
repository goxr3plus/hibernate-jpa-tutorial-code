package com.goxr3plus.jpa.hibernate.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "course")
@NamedQueries(value = { @NamedQuery(name = "get_all_courses", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "query_100_steps_courses", query = "SELECT c FROM Course c where name like '%100 Steps'") })
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(name = "FULLNAME", nullable = false)
	private String name;

	@CreationTimestamp
	// @Column(name = "created_date") //no need
	private LocalDateTime createdDate;

	@UpdateTimestamp
	// @Column(name = "last_updated_date") //no need
	private LocalDateTime lastUpdatedDate;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews;

	public Course() {

	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	public void removeReview(Review review) {
		reviews.remove(review);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}

}
