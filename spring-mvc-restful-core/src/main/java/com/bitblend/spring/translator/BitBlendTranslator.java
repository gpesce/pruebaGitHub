package com.bitblend.spring.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

import com.bitblend.spring.model.MedicalRecord;
import com.bitblend.spring.model.Patient;
import com.bitblend.spring.wrapper.MedicalRecordWrapper;
import com.bitblend.spring.wrapper.PatientWrapper;

@Scope("singleton")
public class BitBlendTranslator {

	public static List<PatientWrapper> getPatientWithMedicalRecordsWrapper(List<Patient> patients) {
		List<PatientWrapper> patientWrapperList = new ArrayList<PatientWrapper>();
		PatientWrapper pw = null;
		for (Patient patient : patients) {
			pw = new PatientWrapper();
			pw.setId(patient.getId());
			pw.setName(patient.getName());
			pw.setGender(patient.getGender());
			for (MedicalRecord medicalRecord : patient.getMedicalRecords()) {
				MedicalRecordWrapper mdw = new MedicalRecordWrapper();
				mdw.setId(medicalRecord.getId());
				mdw.setTitle(medicalRecord.getTitle());
				pw.addMedicalRecord(mdw);
			}
			patientWrapperList.add(pw);
		}
		return patientWrapperList;
	}

	public static List<MedicalRecordWrapper> getMedicalRecordWrapper(List<MedicalRecord> MedicalRecords) {
		List<MedicalRecordWrapper> medicalRecordWrapperList = new ArrayList<MedicalRecordWrapper>();
		for (MedicalRecord medicalRecord : MedicalRecords) {
			MedicalRecordWrapper mdr = new MedicalRecordWrapper();
			mdr.setId(medicalRecord.getId());
			mdr.setTitle(medicalRecord.getTitle());
			medicalRecordWrapperList.add(mdr);
		}
		return medicalRecordWrapperList;
	}

	public static List<PatientWrapper> getPatientWrapperList(List<Patient> patients) {
		List<PatientWrapper> patientWrapperList = new ArrayList<PatientWrapper>();
		PatientWrapper pw = null;
		for (Patient patient : patients) {
			pw = new PatientWrapper();
			pw.setId(patient.getId());
			pw.setName(patient.getName());
			pw.setGender(patient.getGender());
			patientWrapperList.add(pw);
		}
		return patientWrapperList;
	}

	public static PatientWrapper getPatientWrapper(Patient patient) {
		PatientWrapper pw = new PatientWrapper();
		pw.setId(patient.getId());
		pw.setName(patient.getName());
		pw.setGender(patient.getGender());
		return pw;
	}

}
