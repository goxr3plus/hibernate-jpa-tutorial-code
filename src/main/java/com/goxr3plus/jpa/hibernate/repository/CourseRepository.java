package com.goxr3plus.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goxr3plus.jpa.hibernate.entity.Course;
import com.goxr3plus.jpa.hibernate.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public void deleteById(Long id) {
		em.remove(findById(id));
	}

	public Course save(Course course) {
		if (course.getId() == null)
			em.persist(course);
		else
			em.merge(course);

		return course;
	}
	
	public void addReviewForCourse() {
		
		Course course = findById(1003L);
		
		System.err.println(course.getReviews());
		
		
		Review review = new Review("5","Great Hands-On Stuff");
		Review review2 = new Review("5","Hatsoff");
		
		//Set the relationship
		course.addReview(review);
		review.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		
		//Save to database
		em.persist(review);
		em.persist(review2);
		
	}

	public void playWithEntityManager() {

		// Make an instance managed and persistent.
		Course course1 = new Course("Web Services in 100 steps");
		Course course2 = new Course("Angular Js in 100 steps");
		em.persist(course1);
		em.persist(course2);

		// Synchronize the persistence context to the underlying database.
		em.flush();

		// Clear the persistence context, causing all managed entities to become
		// detached. Changes made to entities thathave not been flushed to the database
		// will not bepersisted.
		//
		//em.clear();
		//
		
		//Detach only one
		em.detach(course2);

		// or
		// em.detach(course1)
		// em.detach(course2)

		course1.setName("Web Services in 100 steps - Updated");
		em.flush();

		course2.setName("Angular Js in 100 steps Updated");
		em.flush();

	}

	@RequestMapping
	public void playWithEntityManager2() {

		// Make an instance managed and persistent.
		Course course1 = new Course("Web Services in 100 steps");
		Course course2 = new Course("Angular Js in 100 steps");
		em.persist(course1);
		em.persist(course2);

		// Synchronize the persistence context to the underlying database.
		em.flush();

		course1.setName("Web Services in 100 steps - Updated");
		course2.setName("Angular Js in 100 steps Updated");

		// Refresh the state of the instance from the database,overwriting changes made
		// to the entity, if any.
		em.refresh(course1);

		// Synchronize the persistence context to the underlying database.
		em.flush();

	}
}
