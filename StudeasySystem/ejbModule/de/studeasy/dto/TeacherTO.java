package de.studeasy.dto;

import java.util.ArrayList;

import de.studeasy.common.*;

public class TeacherTO extends PersonTO implements ITeacherTO {
	
	private static final long serialVersionUID = 2405076137604996925L;

	
	private ICourse course;
	
	
	private ArrayList<ILesson> lessons;
	
	
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
