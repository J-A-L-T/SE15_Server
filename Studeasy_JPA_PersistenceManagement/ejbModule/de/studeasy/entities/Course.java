package de.studeasy.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Course implements Serializable {
	
	@Id @GeneratedValue
	private int courseID;
	private int grade;
	//e.g. 5'B'
	private char descriptor;
	@OneToOne
	@JoinColumn(name="classTeacher_FK")
	private Teacher classTeacher;
	
	private ArrayList<Pupil> pupils;
	private ArrayList<Lesson> lessons;
	
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
	public Teacher getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}
	public ArrayList<Pupil> getPupils() {
		return pupils;
	}
	public void setPupils(ArrayList<Pupil> pupils) {
		this.pupils = pupils;
	}
	public ArrayList<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}
}
