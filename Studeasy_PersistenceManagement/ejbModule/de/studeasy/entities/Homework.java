package de.studeasy.entities;

import java.io.Serializable;

import javax.persistence.*;

import de.studeasy.common.*;

@Entity
public class Homework implements Serializable, IHomework {

	private static final long serialVersionUID = 9153525651671974891L;
	
	@Id
	@GeneratedValue
	private int homeworkID;
	private String description;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private ILesson lesson;
	
	public Homework() {
		super();
	}
	
	public Homework(String description, ILesson lesson) {
		super();
		this.description = description;
		this.lesson = lesson;
		this.lesson.addNewHomework(this);
	}
	
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
