package com.vacinations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vacinations.entity.Patient;
import com.vacinations.service.PatientService;

@Controller
@RequestMapping("/vaccinations_patients")
public class PatientController {

	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService thePatientService) {
		this.patientService = thePatientService;
	}
		@GetMapping("/home")
	public String mainPage(Model theModel) {
		List<Patient> patients= patientService.findAll();
		theModel.addAttribute("patients", patients);
		return "patients/listPatient";
	}
	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		Patient patient= new Patient();
		theModel.addAttribute("patient", patient);		
		return "patients/patientForm";	
	}
	@PostMapping("/addPatient")
	public String addPatient(@ModelAttribute("patient") Patient thePatient) {
		//add new Patient.. so we have to setId=0 new Patient
		thePatient.setId(0);
		patientService.save(thePatient);
		return "redirect:/vaccinations_patients/home";	
	}
	 
	@GetMapping("/findPatientByFirstNameOrLastName")
	public String searchPatient(@RequestParam("theSearchName")String theSearchName,Model theModel) {
		List<Patient> patients=patientService.findPatientByFirstNameOrLastName(theSearchName);
		theModel.addAttribute("patients", patients);
		return "patients/listPatient";	
	}
	@GetMapping("/findIsVaccinatedTrue")
	public String getVaccinatedPatients(Model theModel) {
		List<Patient> patients=patientService.findByIsVaccinatedTrue(); 
		theModel.addAttribute("patients", patients);
		return "patients/listPatient";	
	}
	@GetMapping("/findIsVaccinatedFalse")
	public String getUnvaccinatedPatients(Model theModel) {
		List<Patient> patients=patientService.findByIsVaccinatedFalse(); 
		theModel.addAttribute("patients", patients);
		return "patients/listPatient";	
	}
	
}
