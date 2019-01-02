package com.goxr3plus.jpa.hibernate.demo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goxr3plus.jpa.hibernate.DemoApplication;
import com.goxr3plus.jpa.hibernate.entity.Course;
import com.goxr3plus.jpa.hibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class JPQLTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager entityManager;

	@Test
	public void jpql_course_without_students() {
		final TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where c.students is empty",
				Course.class);
		final List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}

	@Test
	public void jpql_course_with_at_least_2_students() {
		final TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where size(c.students) >=2",
				Course.class);
		final List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}

	@Test
	@DisplayName("Get students which their passports have a specific pattern")
	public void jpql_StudentsWithPassportsInASpecificPattern() {
		final TypedQuery<Student> query = entityManager
				.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
		final List<Student> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}

	// JOIN => SELECT c,s from Course c JOIN c.students s
	// LEFT JOIN => SELECT c,s from Course c LEFT JOIN c.students s
	// CROSS JOIN (3 AND 4 => 3*4 =12 ROWS) MATCHES EVERYTHING WITH EVERYTHING =>
	// SELECT c,s FROM Course c , student s
	@Test
	public void join() {
		final Query query = entityManager.createQuery("SELECT c,s FROM Course c LEFT JOIN c.students s");
		final List<Object[]> resultList = query.getResultList();
		for (final Object[] result : resultList) {
			System.err.println("Course " + result[0]);
			System.err.println("Student " + result[1]);
		}
	}
	
	@Test
	public void left_join() {
		final Query query = entityManager.createQuery("SELECT c,s FROM Course c LEFT JOIN c.students s");
		final List<Object[]> resultList = query.getResultList();
		for (final Object[] result : resultList) {
			System.err.println("Course " + result[0]);
			System.err.println("Student " + result[1]);
		}
	}
	
	@Test
	public void cross_join() {
		final Query query = entityManager.createQuery("SELECT c,s FROM Course c , Student s");
		final List<Object[]> resultList = query.getResultList();
		for (final Object[] result : resultList) {
			System.err.println("Course " + result[0]);
			System.err.println("Student " + result[1]);
		}
	}

}
