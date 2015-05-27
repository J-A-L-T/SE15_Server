package de.studeasy.entities;

import javax.persistence.*;

import de.studeasy.registries.PupilRegistry;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Pupil extends Person implements de.studeasy.common.Pupil {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Course course;
	
	public Pupil() {
		super();
		PupilRegistry.getInstance().addPupil(this);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
