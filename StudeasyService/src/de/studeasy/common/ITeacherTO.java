package de.studeasy.common;

import java.util.ArrayList;
import java.util.List;

public interface ITeacherTO extends IPerson {

	public ICourse getCourse();
	public void setCourse(ICourse course);
	public List<ILesson> getLessons();
	public void setLessons(ArrayList<ILesson> lessons);
}
