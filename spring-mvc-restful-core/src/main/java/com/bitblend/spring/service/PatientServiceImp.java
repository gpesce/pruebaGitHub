package com.bitblend.spring.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitblend.spring.dao.DaoInterface;
import com.bitblend.spring.model.MedicalRecord;
import com.bitblend.spring.model.Patient;

@Service
@Transactional(readOnly = true)
public class PatientServiceImp implements ServiceInterface<Patient> {
	
	@Autowired
	private DaoInterface<Patient> patientDao;

	@Transactional
	@Override
	public long save(Patient patient) {
		Timestamp currentTimeMillis = new Timestamp(System.currentTimeMillis());
		patient.setCreationTimestamp(currentTimeMillis);
		patient.setModificationTimestamp(currentTimeMillis);
		patient.setCreationIPAddress("dummy IP");
		patient.setModificationIPAddress("dummy IP");
		patient.setCreationUserId("dummy User");
		patient.setModificationUserId("dummy User");
		for (MedicalRecord medicalRecord : patient.getMedicalRecords()) {
			medicalRecord.setCreationTimestamp(currentTimeMillis);
			medicalRecord.setModificationTimestamp(currentTimeMillis);
			medicalRecord.setCreationIPAddress("dummy IP");
			medicalRecord.setModificationIPAddress("dummy IP");
			medicalRecord.setCreationUserId("dummy User");
			medicalRecord.setModificationUserId("dummy User");
			medicalRecord.setPatient(patient);
		}
		return patientDao.save(patient);
	}

	@Override
	public Patient get(long id) {
		return patientDao.get(id);
	}

	@Override
	public List<Patient> list() {
		return patientDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Patient patient) {
		patientDao.update(id, patient);
	}

	@Transactional
	@Override
	public void delete(long id) {
		patientDao.delete(id);
	}

}
