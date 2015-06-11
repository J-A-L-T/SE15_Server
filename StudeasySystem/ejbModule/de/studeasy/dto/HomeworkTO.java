package de.studeasy.dto;

import java.io.Serializable;
import de.studeasy.common.*;



public class HomeworkTO implements Serializable, IHomeworkTO {

	

	private static final long serialVersionUID = -2470062635073768944L;
	
	private int homeworkID;
	private String description;
	
	
	private ILesson lesson;
	
	
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
	public ILesson getLesson() {
		return lesson;
	}
	public void setLesson(ILesson lesson) {
		this.lesson = lesson;
	}
}
