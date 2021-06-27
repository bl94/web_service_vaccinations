package com.vacinations.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vacinations.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	public List<Patient> findByIsVaccinatedFalse();

	public List<Patient> findByIsVaccinatedTrue();
	
@Query("select p from Patient p where p.firstName = :theSearchName or p.lastName = :theSearchName")
  public List<Patient> findPatientByFirstNameOrLastName(@Param("theSearchName") String searchName);
}
