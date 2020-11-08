package com.bitblend.spring.service;

import java.util.List;

import com.bitblend.spring.model.Patient;

public interface PatientService {

   long save(Patient patient);
   Patient get(long id);
   List<Patient> list();
   void update(long id, Patient patient);
   void delete(long id);
}
