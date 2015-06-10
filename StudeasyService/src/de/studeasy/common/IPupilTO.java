package de.studeasy.common;

public interface IPupilTO extends IPerson {
	public ICourseTO getCourse();
	public void setCourse(ICourseTO course);
}