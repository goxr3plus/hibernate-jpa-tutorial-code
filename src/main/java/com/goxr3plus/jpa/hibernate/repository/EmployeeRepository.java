package com.goxr3plus.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goxr3plus.jpa.hibernate.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	private EntityManager em;

	public void insert(final Employee employee) {
		em.persist(employee);
	}

	public List<Employee> retrieveEmployees() {
		return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
	}

	public Employee findById(final Long id) {
		return em.find(Employee.class, id);
	}

	public void deleteById(final Long id) {
		em.remove(findById(id));
	}

	public Employee save(final Employee employee) {
		if (employee.getId() == null)
			em.persist(employee);
		else
			em.merge(employee);

		return employee;
	}

}
