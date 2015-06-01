package de.studeasy.common;

import java.io.Serializable;

import de.studeasy.entities.Lesson;

public interface IHomework extends Serializable {
	
	public int getHomeworkID();
	
	public void setHomeworkID(int homeworkID);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public ILesson getLesson();
	
	public void setLesson(ILesson lesson);
}