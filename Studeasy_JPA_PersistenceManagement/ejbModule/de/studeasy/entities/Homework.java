package de.studeasy.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Homework implements Serializable{

	private int homeworkID;
	private String description;
	
	public int getHomeworkID() {
		return homeworkID;
	}
	public void setHomeworkID(int homeworkID) {
		this.homeworkID = homeworkID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
