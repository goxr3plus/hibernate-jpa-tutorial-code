package com.goxr3plus.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.goxr3plus.jpa.hibernate.DemoApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DemoApplication.class})
class CourseSpringDataRepositoryTest {

	@Autowired
	private CourseSpringDataRepository courseSpringDataRepository;

	@DisplayName("Test if find all Courses works")
	@Test
	void testFindAll() {
		System.err.println(courseSpringDataRepository.findAll());

		assertTrue(true);
	}

}
