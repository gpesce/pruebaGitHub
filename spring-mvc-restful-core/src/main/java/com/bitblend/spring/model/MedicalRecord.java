package com.bitblend.spring.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MEDICAL_RECORD")
public class MedicalRecord extends AbstractPersistentObject{

	private String title;
	@ManyToOne 
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;

	
	public MedicalRecord() {
		super();
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
