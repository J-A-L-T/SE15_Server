package de.studeasy.entities;

import java.io.Serializable;


import de.studeasy.systeminterfaces.ISubject;

import javax.persistence.*;

/**
 * Subject-Entityklasse aus der mit JPA eine Datenbanktabelle erzeugt wird.
 * @author Tobias Riegel
 *
 */
@Entity
public class Subject implements Serializable, ISubject {

	private static final long serialVersionUID = -1512930899828828250L;
	
	@Id 
	@GeneratedValue
	private int subjectID;
	private String description;
		
	public Subject() {
		super();
	}

	public Subject(String description) {
		super();
		this.description = description;
	}
	
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
