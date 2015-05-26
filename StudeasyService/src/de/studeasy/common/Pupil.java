package de.studeasy.common;

import de.studeasy.entities.Course;

public interface Pupil extends Person {
	public Course getCourse();
	public void setCourse(Course course);
}
