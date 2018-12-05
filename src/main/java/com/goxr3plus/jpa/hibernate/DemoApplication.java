package com.goxr3plus.jpa.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.goxr3plus.jpa.hibernate.entity.Course;
import com.goxr3plus.jpa.hibernate.repository.CourseRepository;

//@Configuration
//@EnableAutoConfiguration()
//@ComponentScan(basePackages = { "com.goxr3plus" })
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(1001L);
		logger.error("Course {1001} => {}",course.getName());
		courseRepository.deleteById(1001L);

		Course course2 = new Course("AHAHAHAHAH:");
		courseRepository.save(course2);
		course.setName("lepleee");
		courseRepository.save(course);
		
		
		courseRepository.playWithEntityManager();
		courseRepository.playWithEntityManager2();
	}
}
