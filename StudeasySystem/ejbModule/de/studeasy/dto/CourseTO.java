package de.studeasy.dto;

import java.io.Serializable;

import java.util.List;

import de.studeasy.common.*;


public class CourseTO implements Serializable, ICourseTO {
	
	private static final long serialVersionUID = -3906372330041256764L;


	private int courseID;
	
	private int grade;
	//e.g. 5'B'
	private char descriptor;
	
	private ITeacherTO classTeacher;
	
	private List<IPupilTO> pupils;
	
	private List<ILessonTO> lessons;
	
	
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
	public List<IPupilTO> getPupils() {
		return pupils;
	}
	public void setPupils(List<IPupilTO> pupils) {
		this.pupils = pupils;
	}
	public List<ILessonTO> getLessons() {
		return lessons;
	}
	public void setLessons(List<ILessonTO> lessons) {
		this.lessons = lessons;
	}
}
