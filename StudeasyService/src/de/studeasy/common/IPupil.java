package de.studeasy.common;

import de.studeasy.entities.Course;

public interface IPupil extends IPerson {
	public ICourse getCourse();
	public void setCourse(ICourse course);
}
