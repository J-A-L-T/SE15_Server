package de.studeasy.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {
	
	@Id
	@GeneratedValue
	private int personID;
	private String name;
	private String firstname;
	//'m'=man 'w'=woman
	private char gender;

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
}
