package de.studeasy.entities;

import java.util.ArrayList;

import java.util.List;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.ITeacher;

import javax.persistence.*;

/**
 * Teacher-Entityklasse aus der mit JPA eine Datenbanktabelle erzeugt wird.
 * @author Tobias Riegel
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Teacher extends Person implements ITeacher {
	
	private static final long serialVersionUID = 2405076137604996925L;

	/*Nicht relevant für die Anwendung
	@OneToOne(cascade=CascadeType.ALL, targetEntity=Course.class)
	@JoinColumn(name="course_FK",nullable=true)
	private ICourse course;*/
	
	@OneToMany(cascade=CascadeType.ALL,
			   mappedBy="teacher",
			   targetEntity=Lesson.class)
	private List<ILesson> lessons;
	
	public Teacher() {
		super();
	}
	
	public Teacher(int personID, String name, String firstname, String password, char gender) {
		super(personID, name, firstname, password, gender);
		this.lessons = new ArrayList<ILesson>();
	}

	public List<ILesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<ILesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public void addNewLesson(ILesson newLesson) {
		this.lessons.add(newLesson);
	}
}
