package com.bitblend.spring.valueobject;

public class PatientControllerValueObject {

	private PatientValueObject patientVO;
	
	public PatientValueObject getPatientVO() {
		if (patientVO == null) {
			this.patientVO = new PatientValueObject();
		}
		return patientVO;
	}

	public void setPatientVO(PatientValueObject patientVO) {
		this.patientVO = patientVO;
	}
	
}

