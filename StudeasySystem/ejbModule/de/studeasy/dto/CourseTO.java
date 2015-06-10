package de.studeasy.dto;

import java.io.Serializable;
import java.util.ArrayList;

import de.studeasy.common.*;


public class CourseTO implements Serializable, ICourseTO {
	
	private static final long serialVersionUID = -3906372330041256764L;


	private int courseID;
	
	private int grade;
	//e.g. 5'B'
	private char descriptor;
	
	private ITeacherTO classTeacher;
	
	private ArrayList<IPupilTO> pupils;
	
	private ArrayList<ILessonTO> lessons;
	
	
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
	public ITeacherTO getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(ITeacherTO classTeacher) {
		this.classTeacher = classTeacher;
	}
	public ArrayList<IPupilTO> getPupils() {
		return pupils;
	}
	public void setPupils(ArrayList<IPupilTO> pupils) {
		this.pupils = pupils;
	}
	public ArrayList<ILessonTO> getLessons() {
		return lessons;
	}
	public void setLessons(ArrayList<ILessonTO> lessons) {
		this.lessons = lessons;
	}
}
