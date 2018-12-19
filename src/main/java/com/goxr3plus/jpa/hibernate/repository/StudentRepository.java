package com.goxr3plus.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goxr3plus.jpa.hibernate.entity.Course;
import com.goxr3plus.jpa.hibernate.entity.Passport;
import com.goxr3plus.jpa.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	private EntityManager em;

	public Student findById(final Long id) {
		return em.find(Student.class, id);
	}

	public void deleteById(final Long id) {
		em.remove(findById(id));
	}

	public Student save(final Student student) {
		if (student.getId() == null)
			em.persist(student);
		else
			em.merge(student);

		return student;
	}

	public void saveStudentWithPassport() {
		final Passport passport = new Passport("Z123456");
		em.persist(passport);
		
		
		final Student student = new Student("Mike");
		student.setPassport(passport);
		
		em.persist(student);
	}
	
	
	public void insertHardCodedStudentAndCourse() {
		final Student student = new Student("LIMAO");
		final Course course  = new Course("Fisting");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
	}
}
