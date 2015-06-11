package de.studeasy.systeminterfaces;

import java.io.Serializable;

/**
 * Interface für die Homework-Entity
 * @author Andreas Prischep
 *
 */
public interface IHomework extends Serializable {
	
	public int getHomeworkID();
	
	public void setHomeworkID(int homeworkID);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public ILesson getLesson();
	
	public void setLesson(ILesson lesson);
}