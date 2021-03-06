package com.goxr3plus.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goxr3plus.jpa.hibernate.DemoApplication;
import com.goxr3plus.jpa.hibernate.entity.Address;
import com.goxr3plus.jpa.hibernate.entity.Course;
import com.goxr3plus.jpa.hibernate.entity.Passport;
import com.goxr3plus.jpa.hibernate.entity.Student;
import com.goxr3plus.jpa.hibernate.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EntityManager em;

	// Session & Session Factory
	// EntityManager & Persistence Context
	// Transaction

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {

		final Student student = em.find(Student.class, 2001L);
		logger.info("Student ->{}", student);
		logger.info("Student ->{}", student.getPassport());

	}

	@Test
	@Transactional
	public void retrieveStudentAndSetAddress() {

		final Student student = em.find(Student.class, 2001L);
		logger.info("Student ->{}", student);
		logger.info("Student ->{}", student.getPassport());
		student.setAddress(new Address("Yes 101", "Some Street", "Hyderbad"));
		em.flush();

		logger.info("Student Address ->{}", student.getAddress());
	}

	@Test
	@Transactional
	public void retrievePassportAndStudentDetails() {

		final Passport passport = em.find(Passport.class, 4001L);
		logger.info("Passport ->{}", passport);
		logger.info("Student ->{}", passport.getStudent());

	}

	@Test
	@Transactional // Persistence Context started here
	public void someTest() {

		// Retrieve Student
		final Student student = em.find(Student.class, 2001L);
		// Persistence Context ( Student )

		// Retrieve Passport
		final Passport passport = student.getPassport();
		// Persistence Context ( Student , Passport )

		// Update Passport
		passport.setNumber("E123457");
		// Persistence Context ( Student , Passport++ )

		// Update Student
		student.setName("Ranga Updated");
		// Persistence Context ( Student++ , Passport )

		// AutoSave all the changes to the database because of @Transactional
	}
	// Persistence Context Dying here because of @Transactional

	// @Ignore // This test is build to fail just to show you why
	@Test
	// @Transactional
	public void noTransactionalTest() {

		// Retrieve Student
		final Student student = studentRepository.findById(2001L);
		// Persistence Context ( Student ) -- End of Transaction

		// Retrieve Passport
		final Passport passport = student.getPassport();

		// Update Passport
		passport.setNumber("E123457");
		// Error there is no transaction ----- No persistence Context

	}

	@Test
	public void transationCrazyTest() {
		transationalProvidedByStudentRepository();
	}

	public void transationalProvidedByStudentRepository() {
		// Retrieve Student
		final Student student = studentRepository.findById(2001L);
		// Persistence Context ( Student ) -- End of Transaction

		// Retrieve Passport
		final Passport passport = student.getPassport();

		// Update Passport
		passport.setNumber("E123457");
		// Error there is no transaction ----- No persistence Context

	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		final Student student = em.find(Student.class, 2001L);
		System.err.println(student);
		System.err.println(student.getCourses());
	}

	@Test
	@Transactional
	public void NPlusOenProblem() {

		final List<Course> courses = em.createNamedQuery("get_all_courses", Course.class).getResultList();
		courses.stream().forEach(course -> {
			logger.info("Course -> {} Students -> {}", course, course.getStudents());
		});
	}

	@Test
	@Transactional
	public void solvingNPlusOenProblem_EntityGraph() {
		final EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		entityGraph.addSubgraph("students");

		final List<Course> courses = em.createNamedQuery("get_all_courses", Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph).getResultList();
		courses.stream().forEach(course -> {
			logger.info("Course -> {} Students -> {}", course, course.getStudents());
		});
	}

	@Test
	@Transactional
	public void solvingNPlusOenProblem_JOIN_FETCH() {

		final List<Course> courses = em.createNamedQuery("get_all_courses_join_fetch", Course.class).getResultList();
		courses.stream().forEach(course -> {
			logger.info("Course -> {} Students -> {}", course, course.getStudents());
		});
	}

}
