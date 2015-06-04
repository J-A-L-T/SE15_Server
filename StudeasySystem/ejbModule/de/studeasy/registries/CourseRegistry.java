package de.studeasy.registries;

import java.util.HashMap;


import de.studeasy.common.ICourse;

public class CourseRegistry {
	
	private static CourseRegistry singleInstance = new CourseRegistry();
	
	private HashMap<Integer,ICourse> courses;
	
	private CourseRegistry() {
		courses = new HashMap<>();
	}
	
	public static CourseRegistry getInstance() {
		return singleInstance;
	}
	
	public ICourse findCourseById(int id) {
		return this.courses.get(id);
	}
	
	public void addCourse(ICourse newCourse) {
		this.courses.put(newCourse.getCourseID(), newCourse);
	}
}
