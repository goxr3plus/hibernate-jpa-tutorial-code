package com.goxr3plus.jpa.hibernate.demo;

import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goxr3plus.jpa.hibernate.DemoApplication;
import com.goxr3plus.jpa.hibernate.entity.Course;
import com.goxr3plus.jpa.hibernate.entity.Review;
import com.goxr3plus.jpa.hibernate.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	public void testCourse() {
		final Course course = courseRepository.findById(1001L);
		System.err.println(course);
		System.out.println(course.getReviews());
	}

	@Test
	// @Transactional
	public void testReview() {
		final Review review = entityManager.find(Review.class, 5001L);
		System.err.println(review);
		System.err.println(review.getCourse());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		courseRepository.deleteById(1002L);
		assertNull(courseRepository.findById(1002L));
	}

}
