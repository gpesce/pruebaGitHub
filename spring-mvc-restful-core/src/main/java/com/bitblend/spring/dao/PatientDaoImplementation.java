package com.bitblend.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitblend.spring.model.Patient;

@Repository
public class PatientDaoImplementation implements DaoInterface<Patient> {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Patient patient) {
      sessionFactory.getCurrentSession().save(patient);
      return patient.getId();
   }

   @Override
   public Patient get(long id) {
      return sessionFactory.getCurrentSession().get(Patient.class, id);
   }

   @Override
   public List<Patient> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);
      Root<Patient> root = cq.from(Patient.class);
      cq.select(root);
      Query<Patient> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Patient patient) {
      Session session = sessionFactory.getCurrentSession();
      Patient persistedPatient = session.byId(Patient.class).load(id);
      persistedPatient.setName(patient.getName());
      persistedPatient.setGender(patient.getGender());
      persistedPatient.setMedicalRecords(patient.getMedicalRecords());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Patient patient = session.byId(Patient.class).load(id);
      session.delete(patient);
   }

}
