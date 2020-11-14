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
import com.bitblend.spring.translator.BitBlendTranslator;
import com.bitblend.spring.wrapper.PatientWrapper;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class PatientController {

	@Autowired
	private ServiceInterface<Patient> patientService;

	/*---Add new patient---*/
	@PostMapping("/patientWithMedicalRecords")
   public ResponseEntity<?> save(@RequestBody Patient patient) {
	   long id = patientService.save(patient);
	   return ResponseEntity.ok().body("New Patient has been saved with ID:" + id);
   }
	
	/*---Add new patient---*/
	@PostMapping("/patient")
	   public ResponseEntity<?> saveSimple(@RequestBody Patient patient) {
		   long id = patientService.save(patient);
		   return ResponseEntity.ok().body("New Patient has been saved with ID:" + id);
	   }
	
	/*---Get an patient by id---*/
	@GetMapping("/patient/{id}")
	public ResponseEntity<PatientWrapper> get(@PathVariable("id") long id) {
		PatientWrapper patient = BitBlendTranslator.getPatientWrapper(patientService.get(id));
		return ResponseEntity.ok().body(patient);
	}

	/*---get all patients---*/
	@GetMapping("/getPatients")
	public ResponseEntity<List<PatientWrapper>> list2() {
		List<PatientWrapper> patients = BitBlendTranslator.getPatientWrapperList(patientService.list());
		return ResponseEntity.ok().body(patients);
	}

	@GetMapping("/getPatientWithMedicalRecords")
	public ResponseEntity<List<PatientWrapper>> list() {
		List<PatientWrapper> patients = BitBlendTranslator.getPatientWithMedicalRecordsWrapper(patientService.list());
		return ResponseEntity.ok().body(patients);
	}

	/*---Update an patient by id---*/
	@PutMapping("/patient/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Patient patient) {
		patientService.update(id, patient);
		return ResponseEntity.ok().body("Patient has been updated successfully.");
	}

	/*---Delete an patient by id---*/
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		patientService.delete(id);
		return ResponseEntity.ok().body("Patient has been deleted successfully.");
	}
	
}