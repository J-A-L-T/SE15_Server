package de.studeasy.entities;

import java.util.ArrayList;

import de.studeasy.common.*;
import javax.persistence.*;

import de.studeasy.registries.PersonRegistry;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Teacher extends Person implements ITeacher {
	
	private static final long serialVersionUID = 2405076137604996925L;

	@OneToOne(cascade=CascadeType.PERSIST)
	private ICourse course;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="teacher")
	@JoinColumn(name="teacher_FK")
	private ArrayList<ILesson> lessons;
	
	public Teacher() {
		super();
		PersonRegistry.getInstance().addPerson(this);
	}
	
	public ICourse getCourse() {
		return course;
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}

	public ArrayList<ILesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<ILesson> lessons) {
		this.lessons = lessons;
	}
}
