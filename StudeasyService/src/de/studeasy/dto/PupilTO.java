package de.studeasy.dto;

import javax.persistence.*;

import de.studeasy.common.*;


public class PupilTO extends PersonTO implements IPupil {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private ICourse course;
	


	public ICourse getCourse() {
		return course;
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}
}
