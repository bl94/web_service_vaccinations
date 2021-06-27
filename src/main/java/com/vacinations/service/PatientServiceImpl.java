package com.vacinations.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacinations.entity.Patient;
import com.vacinations.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository thePatientRepository) {
		this.patientRepository = thePatientRepository;
	}

	@Override
	public void save(Patient patient) {
		patientRepository.save(patient);
	}

	@Override
	public Patient findById(int id) {
		Optional<Patient> optional=patientRepository.findById(id);
		Patient patient = null;
		if(optional.isPresent()) {
			patient=optional.get();
		}
		else {
			throw new RuntimeException("Did not found patient id "+ id);
		}
		return patient;
	}

	@Override
	public List<Patient> findByIsVaccinatedTrue() {
		return patientRepository.findByIsVaccinatedTrue();
}
	@Override
	public List<Patient> findAll(){
		return patientRepository.findAll();
	}

	@Override
	public List<Patient> findByIsVaccinatedFalse() {
		return patientRepository.findByIsVaccinatedFalse();
	}

	@Override
	public List<Patient> findPatientByFirstNameOrLastName(String theSearchName) {
		return patientRepository.findPatientByFirstNameOrLastName(theSearchName);
	}

}
