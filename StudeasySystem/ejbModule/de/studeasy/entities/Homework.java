package de.studeasy.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Homework implements Serializable, de.studeasy.common.Homework {

	private static final long serialVersionUID = 9153525651671974891L;
	
	@Id
	@GeneratedValue
	private int homeworkID;
	private String description;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Lesson lesson;
	
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
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
}
