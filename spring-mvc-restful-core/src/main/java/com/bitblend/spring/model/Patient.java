package com.bitblend.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1136587018406751600L;
	
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;

	
	public Patient() {
		super();
	}

	
	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	

}
