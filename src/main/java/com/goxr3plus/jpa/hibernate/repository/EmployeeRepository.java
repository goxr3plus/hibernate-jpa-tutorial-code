package com.goxr3plus.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goxr3plus.jpa.hibernate.entity.Employee;
import com.goxr3plus.jpa.hibernate.entity.FullTimeEmployee;
import com.goxr3plus.jpa.hibernate.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	private EntityManager em;

	public void insert(final Employee employee) {
		em.persist(employee);
	}

	public List<PartTimeEmployee> retrievePartTimeEmployees() {
		return em.createQuery("SELECT e FROM PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> retrieveFullTimeEmployees() {
		return em.createQuery("SELECT e FROM FullTimeEmployee e", FullTimeEmployee.class).getResultList();
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
