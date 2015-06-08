package de.studeasy.entities;

import javax.persistence.*;

import de.studeasy.common.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Pupil extends Person implements IPupil {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private ICourse course;
	
	public Pupil() {
		super();
	}

	public Pupil(String name, String firstname, String password, char gender, ICourse course) {
		super(name, firstname, password, gender);
		this.course = course;
		this.course.addNewPupil(this);
	}

	public ICourse getCourse() {
		return course;
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}
}
