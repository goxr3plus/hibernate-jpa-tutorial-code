package com.goxr3plus.jpa.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(nullable = false)
	private String number;

	public Passport() {

	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
