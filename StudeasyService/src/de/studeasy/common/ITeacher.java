package de.studeasy.common;

import java.util.ArrayList;
import java.util.List;

public interface ITeacher extends IPerson {

	public ICourse getCourse();
	public void setCourse(ICourse course);
	public List<ILesson> getLessons();
	public void setLessons(ArrayList<ILesson> lessons);
	public void addNewLesson(ILesson newLesson);
}
