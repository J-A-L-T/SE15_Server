package de.studeasy.dto;

import de.studeasy.common.*;


public class PupilTO extends PersonTO implements IPupilTO {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	private ICourse course;
	
	public ICourse getCourse() {
		return course;
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}
}
