package com.bitblend.spring.wrapper;

import java.util.ArrayList;
import java.util.List;

public class PatientWrapper {

	private Long id;
	private String name;
	private String gender;
    private List<MedicalRecordWrapper> medicalRecords;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public List<MedicalRecordWrapper> getMedicalRecords() {
		if (medicalRecords == null) {
			this.medicalRecords = new ArrayList<MedicalRecordWrapper>();
		}
		return medicalRecords;
	}
	
	public void setMedicalRecords(List<MedicalRecordWrapper> medicalRecordss) {
		this.medicalRecords = medicalRecordss;
	}

	public void addMedicalRecord(MedicalRecordWrapper medicalRecordss) {
		this.getMedicalRecords().add(medicalRecordss);
	}
}
