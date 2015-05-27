package de.studeasy.entities;

import java.io.Serializable;

import javax.persistence.*;

import de.studeasy.registries.SubjectRegistry;


@Entity
public class Subject implements Serializable, de.studeasy.common.Subject {

	private static final long serialVersionUID = -1512930899828828250L;
	
	@Id 
	@GeneratedValue
	private int subjectID;
	private String description;
	
	public Subject() {
		SubjectRegistry.getInstance().addSubject(this);
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
