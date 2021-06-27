package com.vacinations.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="first_Name")
	private String firstName;
	@Column(name="last_Name")
	private String lastName;
	@Column(name="age")
	private int age;
	@Column( columnDefinition = "BIT", name="is_Vaccinated")
	private Boolean isVaccinated;
	
	public Patient() {

	}
	
	public Patient(String firstName, String lastName, int age, Boolean isVaccinated) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.isVaccinated = isVaccinated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getIsVaccinated() {
	    return isVaccinated;
	}

	public void setIsVaccinated(Boolean isVaccinated) {
		      this.isVaccinated= isVaccinated;
	}

}
