package com.goxr3plus.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.goxr3plus.jpa.hibernate.DemoApplication;
import com.goxr3plus.jpa.hibernate.entity.Course;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { DemoApplication.class })
class CourseSpringDataRepositoryTest {

	@Autowired
	private CourseSpringDataRepository courseSpringDataRepository;

	@DisplayName("Test if find all Courses works")
	@Test
	void testFindAll() {
		System.err.println(courseSpringDataRepository.findAll());

		assertTrue(true);
	}

	@Test
	void sort() {
		final Sort sort = new Sort(Direction.DESC, "name");
		System.err.println(courseSpringDataRepository.findAll(sort));
	}

	@Test
	void pagination() {
		final PageRequest pageRequest = PageRequest.of(0, 3);

		final Page<Course> firstPage = courseSpringDataRepository.findAll(pageRequest);
		System.err.println(firstPage.getContent());

		final Pageable secondPageable = firstPage.nextPageable();
		final Page<Course> secondPage = courseSpringDataRepository.findAll(secondPageable);
		System.err.println(secondPage.getContent());

	}

}
