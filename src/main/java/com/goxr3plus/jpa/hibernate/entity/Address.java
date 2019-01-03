package com.goxr3plus.jpa.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String line1;
	private String line2;
	private String city;

	public Address() {
		super();
	}

	public Address(final String line1, final String line2, final String city) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getCity() {
		return city;
	}

}
