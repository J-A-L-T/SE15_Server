package de.studeasy.entities;

import javax.persistence.*;

import de.studeasy.common.*;
import de.studeasy.registries.PersonRegistry;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Pupil extends Person implements IPupil {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private ICourse course;
	
	public Pupil() {
		super();
		PersonRegistry.getInstance().addPerson(this);
	}

	public ICourse getCourse() {
		return course;
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}
}
