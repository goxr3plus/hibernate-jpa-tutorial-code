package com.goxr3plus.jpa.hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
@NamedQuery(name = "get_all_courses", query = "SELECT c FROM Course c")
@NamedQuery(name = "get_all_courses_join_fetch", query = "SELECT c FROM Course c JOIN FETCH c.students s")
@NamedQuery(name = "query_100_steps_courses", query = "SELECT c FROM Course c where name like '%100 Steps'")
@Cacheable
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
public class Course {

	private static final Logger logger = LoggerFactory.getLogger(Course.class);

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

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@PreRemove
	private void preRemove() {
		logger.info("Setting is_deleted to true");
		this.isDeleted = true;
	}

	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private final List<Student> students = new ArrayList<>();

	public Course() {

	}

	public Course(final String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(final Review review) {
		reviews.add(review);
	}

	public void removeReview(final Review review) {
		reviews.remove(review);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(final Student e) {
		this.students.add(e);
	}

}
