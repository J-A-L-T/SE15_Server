package de.studeasy.systeminterfaces;

import java.util.List;


/**
 * Interface für die Teacher-Entity
 * @author Andreas Prischep
 *
 */
public interface ITeacher extends IPerson {

	public List<ILesson> getLessons();
	public void setLessons(List<ILesson> lessons);
	public void addNewLesson(ILesson newLesson);
}
