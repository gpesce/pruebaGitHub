package com.bitblend.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitblend.spring.dao.PatientDao;
import com.bitblend.spring.model.Patient;

@Service
@Transactional(readOnly = true)
public class PatientServiceImp implements PatientService {

   @Autowired
   private PatientDao patientDao;

   @Transactional
   @Override
   public long save(Patient patient) {
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
