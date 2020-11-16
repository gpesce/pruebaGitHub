package com.bitblend.spring.valueobject;

import java.util.ArrayList;
import java.util.List;

public class PatientValueObject {

	private Long id;
	private String name;
	private String gender;
    private List<MedicalRecordValueObject> medicalRecords;
	
	
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
	
	public List<MedicalRecordValueObject> getMedicalRecords() {
		if (medicalRecords == null) {
			this.medicalRecords = new ArrayList<MedicalRecordValueObject>();
		}
		return medicalRecords;
	}
	
	public void setMedicalRecords(List<MedicalRecordValueObject> medicalRecordss) {
		this.medicalRecords = medicalRecordss;
	}

	public void addMedicalRecord(MedicalRecordValueObject medicalRecordss) {
		this.getMedicalRecords().add(medicalRecordss);
	}
}
