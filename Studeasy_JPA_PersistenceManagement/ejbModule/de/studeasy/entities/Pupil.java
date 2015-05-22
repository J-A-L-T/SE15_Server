package de.studeasy.entities;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Pupil extends Person {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Course course;
	
	public Pupil() {
		super();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
