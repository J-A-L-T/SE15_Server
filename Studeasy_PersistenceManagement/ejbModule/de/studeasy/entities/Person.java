package de.studeasy.entities;

import java.io.Serializable;


import de.studeasy.systeminterfaces.IPerson;

import javax.persistence.*;

/**
 * Person-Entityklasse aus der mit JPA eine Datenbanktabelle erzeugt wird.
 * @author Tobias Riegel
 *
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable, IPerson {
	
	private static final long serialVersionUID = 849222223534910538L;
	
	@Id
	private int personID;
	private String name;
	private String firstname;
	private String password;
	//'m'=man 'w'=woman
	private char gender;

	public Person() {
		super();
	}
	
	public Person(int personID, String name, String firstname, String password, char gender) {
		super();
		this.personID = personID;
		this.name = name;
		this.firstname = firstname;
		this.password = password;
		this.gender = gender;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
}
