package de.studeasy.common;

import java.util.ArrayList;

import de.studeasy.entities.Course;
import de.studeasy.entities.Lesson;

public interface ITeacher extends IPerson {

	public ICourse getCourse();
	public void setCourse(ICourse course);
	public ArrayList<ILesson> getLessons();
	public void setLessons(ArrayList<ILesson> lessons);
}
