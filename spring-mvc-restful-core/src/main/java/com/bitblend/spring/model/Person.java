package com.bitblend.spring.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends AbstractPersistentObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -223446166626955188L;
	
	
	@Column(name = "NAME", length = 50, nullable = false)
	private String name;
	@Column(name = "GENDER", length = 1, nullable = false)
	private String gender;

	
	public Person() {
		super();
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



}
