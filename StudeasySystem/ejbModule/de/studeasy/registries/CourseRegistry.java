package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Course;

public class CourseRegistry {
	
	private static CourseRegistry singleInstance = new CourseRegistry();
	
	private HashMap<Integer,Course> courses;
	
	private CourseRegistry() {
		courses = new HashMap<>();
	}
	
	public static CourseRegistry getInstance() {
		return singleInstance;
	}
	
	public Course findCourseById(int id) {
		return this.courses.get(id);
	}
	
	public void addCourse(Course newCourse) {
		this.courses.put(newCourse.getCourseID(), newCourse);
	}
}
