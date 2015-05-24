package de.studeasy.common;

import java.io.Serializable;

public interface Homework extends Serializable {
	
	public int getHomeworkID();
	
	public void setHomeworkID(int homeworkID);
	
	public String getDescription();
	
	public void setDescription(String description);
}