package de.studeasy.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Subject implements Serializable {

	private int subjectID;
	private String description;
	
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
