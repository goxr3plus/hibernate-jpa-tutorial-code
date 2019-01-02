package com.goxr3plus.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.goxr3plus.jpa.hibernate.DemoApplication;
import com.goxr3plus.jpa.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
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
	public void jpql_course_order_by_students() {
		final TypedQuery<Course> query = entityManager
				.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
		final List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}
}
