package de.studeasy.entities;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Teacher extends Person {
	
	private static final long serialVersionUID = 2405076137604996925L;

	@OneToOne(cascade=CascadeType.PERSIST)
	private Course course;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="teacher")
	@JoinColumn(name="teacher_FK")
	private ArrayList<Lesson> lessons;
	
	public Teacher() {
		super();
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}
}
