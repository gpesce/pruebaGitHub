package com.bitblend.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitblend.spring.model.Patient;
import com.bitblend.spring.service.ServiceInterface;
import com.bitblend.spring.translator.PatientControllerTranslator;
import com.bitblend.spring.valueobject.PatientControllerValueObject;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class PatientController {

	@Autowired
	private ServiceInterface<Patient> patientService;

	/*---Add only a new patient---*/
	@PostMapping("/patient")
	public ResponseEntity<?> save(@RequestBody Patient patient) {
		long id = patientService.save(patient);
		return ResponseEntity.ok().body("New Patient has been saved with ID:" + id);
	}
	
	/*---Update patient by id---*/
	@PutMapping("/patient/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Patient patient) {
		patientService.update(id, patient);
		return ResponseEntity.ok().body("Patient has been updated successfully.");
	}

	/*---Delete patient by id---*/
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		patientService.delete(id);
		return ResponseEntity.ok().body("Patient has been deleted successfully.");
	}
	
	/*---Get patient by id---*/
	@GetMapping("/patient/{id}")
	public ResponseEntity<PatientControllerValueObject> get(@PathVariable("id") long id) {
		PatientControllerValueObject patient = PatientControllerTranslator.getPatientControllerValueObject(patientService.get(id));
		return ResponseEntity.ok().body(patient);
	}

	/*---get all patients with its medical records---*/
	@GetMapping("/patient")
	public ResponseEntity<List<PatientControllerValueObject>> list() {
		List<PatientControllerValueObject> patients = PatientControllerTranslator.getPatientControllerValueObjectList(patientService.list());
		return ResponseEntity.ok().body(patients);
	}

	/*---get all patients, without any medical records---*/
	@GetMapping("/onlyPatient")
	public ResponseEntity<List<PatientControllerValueObject>> list2() {
		List<PatientControllerValueObject> patients = PatientControllerTranslator.getOnlyPatients(patientService.list());
		return ResponseEntity.ok().body(patients);
	}

}