package de.studeasy.common;

import java.util.ArrayList;

import de.studeasy.entities.Course;
import de.studeasy.entities.Lesson;

public interface Teacher extends Person {

	public Course getCourse();
	public void setCourse(Course course);
	public ArrayList<Lesson> getLessons();
	public void setLessons(ArrayList<Lesson> lessons);
}
