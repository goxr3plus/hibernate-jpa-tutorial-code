package com.goxr3plus.jpa.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.goxr3plus.jpa.hibernate.entity.Course;

@RepositoryRestResource(path = "/courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	List<Course> findByNameAndId(String name, Long id);

	List<Course> findByName(String name);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);
}
