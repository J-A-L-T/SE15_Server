package de.studeasy.dto;

import java.io.Serializable;

import de.studeasy.common.*;


public class SubjectTO implements Serializable, ISubject {

	private static final long serialVersionUID = -1512930899828828250L;
	
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
