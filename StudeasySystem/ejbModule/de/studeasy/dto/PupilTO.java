package de.studeasy.dto;

import de.studeasy.common.*;


public class PupilTO extends PersonTO implements IPupilTO {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	private ICourseTO course;
	
	public ICourseTO getCourse() {
		return course;
	}

	public void setCourse(ICourseTO course) {
		this.course = course;
	}
}
