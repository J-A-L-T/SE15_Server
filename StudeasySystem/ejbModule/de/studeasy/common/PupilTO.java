package de.studeasy.common;


public class PupilTO extends PersonTO {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	private CourseTO course;
	
	public CourseTO getCourse() {
		return course;
	}

	public void setCourse(CourseTO course) {
		this.course = course;
	}
}
