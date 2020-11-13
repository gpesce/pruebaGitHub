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
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class PatientController {

	@Autowired
	private ServiceInterface<Patient> patientService;

	/*---Add new patient---*/
	@PostMapping("/patientWithMedicalRecords")
	public ResponseEntity<?> save(@RequestBody Patient patient) {
		System.out.println("Salvando Patient wiht medical records");
		long id = patientService.save(patient);
		return ResponseEntity.ok().body("New Patient has been saved with ID:" + id);
	}

	/*---Add new patient---*/
	@PostMapping("/patient")
	public ResponseEntity<?> saveSimple(@RequestBody Patient patient) {
		System.out.println("Salvando Patient");
		long id = patientService.save(patient);
		return ResponseEntity.ok().body("New Patient has been saved with ID:" + id);
	}

	/*---Get an patient by id---*/
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> get(@PathVariable("id") long id) {
		Patient patient = patientService.get(id);
		return ResponseEntity.ok().body(patient);
	}

	/*---get all patients---*/
	@GetMapping("/getPatients")
	public ResponseEntity<String> list2() {
		List<Patient> patients = patientService.list();
		String json = new Gson().toJson(patients);
		String parsedJson = json.substring(1, json.length() - 1);
		System.out.println(parsedJson);
		return ResponseEntity.ok().body(parsedJson);
	}

	@GetMapping("/getPatientWithMedicalRecords")
	public ResponseEntity<List<PatientWrapper>> list() {
		List<PatientWrapper> patients = BitBlendTranslator.getPatientWrapper(patientService.list());
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