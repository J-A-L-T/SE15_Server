package de.studeasy.common;

import java.io.Serializable;

import de.studeasy.entities.Lesson;

public interface Homework extends Serializable {
	
	public int getHomeworkID();
	
	public void setHomeworkID(int homeworkID);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public Lesson getLesson();
	
	public void setLesson(Lesson lesson);
}