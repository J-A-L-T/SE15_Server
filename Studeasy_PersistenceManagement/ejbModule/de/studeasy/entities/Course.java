package de.studeasy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
			  mappedBy="course",
			  targetEntity=Teacher.class)
	private ITeacher classTeacher;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="course",
			   targetEntity=Pupil.class)
	private List<IPupil> pupils;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="course",
			   targetEntity=Lesson.class)
	private List<ILesson> lessons;
	
	public Course() {
		super();
	}
	
	
	public Course(int grade, char descriptor, ITeacher classTeacher) {
		super();
		this.grade = grade;
		this.descriptor = descriptor;
		this.classTeacher = classTeacher;
		this.classTeacher.setCourse(this);
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
	public ITeacher getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(ITeacher classTeacher) {
		this.classTeacher = classTeacher;
	}
	public List<IPupil> getPupils() {
		return pupils;
	}
	public void setPupils(ArrayList<IPupil> pupils) {
		this.pupils = pupils;
	}
	public List<ILesson> getLessons() {
		return lessons;
	}
	public void setLessons(ArrayList<ILesson> lessons) {
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
