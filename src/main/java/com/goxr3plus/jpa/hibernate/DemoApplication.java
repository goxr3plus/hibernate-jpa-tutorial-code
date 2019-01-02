package com.goxr3plus.jpa.hibernate;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.goxr3plus.jpa.hibernate.entity.FullTimeEmployee;
import com.goxr3plus.jpa.hibernate.entity.PartTimeEmployee;
import com.goxr3plus.jpa.hibernate.repository.CourseRepository;
import com.goxr3plus.jpa.hibernate.repository.EmployeeRepository;
import com.goxr3plus.jpa.hibernate.repository.StudentRepository;

//@Configuration
//@EnableAutoConfiguration()
//@ComponentScan(basePackages = { "com.goxr3plus" })
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {

//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal(1000)));
//		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal(50)));
//
//		System.err.println("Part Time : "+employeeRepository.retrievePartTimeEmployees());
//		System.err.println("Full Time : "+employeeRepository.retrieveFullTimeEmployees());

	}
}
