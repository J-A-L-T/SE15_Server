package de.studeasy.entities;

import java.io.Serializable;


import java.util.ArrayList;

import javax.persistence.*;

import de.studeasy.common.*;

@Entity
public class Course implements Serializable, ICourse {
	
	private static final long serialVersionUID = -3906372330041256764L;

	@Id @GeneratedValue
	private int courseID;
	
	private int grade;
	//e.g. 5'B'
	private char descriptor;
	
	@OneToOne(cascade=CascadeType.PERSIST,
			  mappedBy="course")
	@JoinColumn(name="classTeacher_FK")
	private ITeacher classTeacher;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="course")
	@JoinColumn(name="course_FK")
	private ArrayList<IPupil> pupils;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="course")
	@JoinColumn(name="course_FK")
	private ArrayList<ILesson> lessons;
	
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
	public ITeacher getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(ITeacher classTeacher) {
		this.classTeacher = classTeacher;
	}
	public ArrayList<IPupil> getPupils() {
		return pupils;
	}
	public void setPupils(ArrayList<IPupil> pupils) {
		this.pupils = pupils;
	}
	public ArrayList<ILesson> getLessons() {
		return lessons;
	}
	public void setLessons(ArrayList<ILesson> lessons) {
		this.lessons = lessons;
	}
}
