package de.studeasy.entities;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IPupil;

/**
 * Course-Entityklasse aus der mit JPA eine Datenbanktabelle erzeugt wird.
 * @author Tobias Riegel
 *
 */
@Entity
public class Course implements Serializable, ICourse {
	
	private static final long serialVersionUID = -3906372330041256764L;

	@Id @GeneratedValue
	private int courseID;
	
	private int grade;
	//e.g. 5'B'
	private char descriptor;
	
	/*Nicht relevant für die Anwendung
	@OneToOne(cascade=CascadeType.ALL,
			  mappedBy="course",
			  targetEntity=Teacher.class)
	private ITeacher classTeacher;*/
	
	@OneToMany(cascade=CascadeType.ALL,
			   mappedBy="course",
			   targetEntity=Pupil.class)
	private List<IPupil> pupils;
	
	@OneToMany(cascade=CascadeType.ALL,
			   mappedBy="course",
			   targetEntity=Lesson.class)
	private List<ILesson> lessons;
	
	public Course() {
		super();
	}
	
	
	public Course(int grade, char descriptor) {
		super();
		this.grade = grade;
		this.descriptor = descriptor;
		this.pupils = new ArrayList<IPupil>();
		this.lessons = new ArrayList<ILesson>();
	}

	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(char descriptor) {
		this.descriptor = descriptor;
	}
	public List<IPupil> getPupils() {
		return pupils;
	}
	public void setPupils(List<IPupil> pupils) {
		this.pupils = pupils;
	}
	public List<ILesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<ILesson> lessons) {
		this.lessons = lessons;
	}


	@Override
	public void addNewPupil(IPupil newPupil) {
		this.pupils.add(newPupil);
	}


	@Override
	public void addNewLesson(ILesson newLesson) {
		this.lessons.add(newLesson);
	}
}
