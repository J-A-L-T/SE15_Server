package de.studeasy.common;

public interface IPupilTO extends IPersonTO {
	public ICourseTO getCourse();
	public void setCourse(ICourseTO course);
}