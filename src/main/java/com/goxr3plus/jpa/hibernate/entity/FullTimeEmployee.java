package com.goxr3plus.jpa.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class FullTimeEmployee extends Employee {

	private BigDecimal salary;

	public FullTimeEmployee() {
	}

	public FullTimeEmployee(@NotNull final String name, final BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(final BigDecimal salary) {
		this.salary = salary;
	}

}
