package com.goxr3plus.jpa.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;

	public PartTimeEmployee() {
	}

	public PartTimeEmployee(@NotNull final String name, final BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(final BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
}
