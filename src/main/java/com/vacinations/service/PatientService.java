package com.vacinations.service;

import java.util.List;

import com.vacinations.entity.Patient;


public interface PatientService {

	public void save(Patient patient);

	public Patient findById(int id);
	
	public List<Patient> findByIsVaccinatedTrue();

	public List<Patient> findAll();

	public List<Patient> findByIsVaccinatedFalse();

	public List<Patient> findPatientByFirstNameOrLastName(String theSearchName);
}
