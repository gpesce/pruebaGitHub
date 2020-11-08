package com.bitblend.spring.dao;

import java.util.List;

import com.bitblend.spring.model.Patient;

public interface PatientDao {

   long save(Patient patient);

   Patient get(long id);

   List<Patient> list();

   void update(long id, Patient patient);

   void delete(long id);

}
