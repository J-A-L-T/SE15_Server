package de.studeasy.entities;

import java.util.ArrayList;

import java.util.List;

import de.studeasy.systeminterfaces.ICourse;
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

	@OneToOne(cascade=CascadeType.PERSIST, targetEntity=Course.class)
	@JoinColumn(name="classTeacher_FK",nullable=true)
	private ICourse course;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="teacher",
			   targetEntity=Lesson.class)
	private List<ILesson> lessons;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, String firstname, String password, char gender, ICourse course) {
		super(name, firstname, password, gender);
		this.course = course;
		this.course.setClassTeacher(this);
		this.lessons = new ArrayList<ILesson>();
	}

	public ICourse getCourse() {
		return course;
	}

	public void setCourse(ICourse course) {
		this.course = course;
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
