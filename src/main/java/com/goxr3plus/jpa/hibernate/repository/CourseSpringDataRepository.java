package com.goxr3plus.jpa.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goxr3plus.jpa.hibernate.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
