package com.bitblend.spring.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

import com.bitblend.spring.model.MedicalRecord;
import com.bitblend.spring.model.Patient;
import com.bitblend.spring.valueobject.MedicalRecordValueObject;
import com.bitblend.spring.valueobject.PatientControllerValueObject;


@Scope("singleton")
public class PatientControllerTranslator {

	public static List<PatientControllerValueObject> getPatientControllerValueObjectList(List<Patient> patients) {
		List<PatientControllerValueObject> pcvoList = new ArrayList<PatientControllerValueObject>();
		PatientControllerValueObject pcvo;
		for (Patient patient : patients) {
			pcvo = new PatientControllerValueObject();
			pcvo.getPatientVO().setId(patient.getId());
			pcvo.getPatientVO().setName(patient.getName());
			pcvo.getPatientVO().setGender(patient.getGender());
			for (MedicalRecord medicalRecord : patient.getMedicalRecords()) {
				MedicalRecordValueObject mrvo = new MedicalRecordValueObject();
				mrvo.setId(medicalRecord.getId());
				mrvo.setTitle(medicalRecord.getTitle());
				pcvo.getPatientVO().addMedicalRecord(mrvo);
			}
			pcvoList.add(pcvo);
		}
		return pcvoList;
	}

	public static List<PatientControllerValueObject> getOnlyPatients(List<Patient> patients) {
		List<PatientControllerValueObject> pcvoList = new ArrayList<PatientControllerValueObject>();
		PatientControllerValueObject pcvo;
		for (Patient patient : patients) {
			pcvo = new PatientControllerValueObject();
			pcvo.getPatientVO().setId(patient.getId());
			pcvo.getPatientVO().setName(patient.getName());
			pcvo.getPatientVO().setGender(patient.getGender());
			pcvoList.add(pcvo);
		}
		return pcvoList;
	}

	public static PatientControllerValueObject getPatientControllerValueObject(Patient patient) {
		PatientControllerValueObject pcvo = new PatientControllerValueObject();
		pcvo.getPatientVO().setId(patient.getId());
		pcvo.getPatientVO().setName(patient.getName());
		pcvo.getPatientVO().setGender(patient.getGender());
		for (MedicalRecord medicalRecord : patient.getMedicalRecords()) {
			MedicalRecordValueObject mrvo = new MedicalRecordValueObject();
			mrvo.setId(medicalRecord.getId());
			mrvo.setTitle(medicalRecord.getTitle());
			pcvo.getPatientVO().addMedicalRecord(mrvo);
		}
		return pcvo;
	}

}
