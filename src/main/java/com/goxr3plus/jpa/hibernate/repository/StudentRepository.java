package com.goxr3plus.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goxr3plus.jpa.hibernate.entity.Passport;
import com.goxr3plus.jpa.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	private EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public void deleteById(Long id) {
		em.remove(findById(id));
	}

	public Student save(Student student) {
		if (student.getId() == null)
			em.persist(student);
		else
			em.merge(student);

		return student;
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);
		
		
		Student student = new Student("Mike");
		student.setPassport(passport);
		
		em.persist(student);
	}
}
