package com.goxr3plus.jpa.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(nullable = false)
	private String name;

	public Student() {

	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

}
