package de.studeasy.entities;

import javax.persistence.*;


import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.IPupil;

/**
 * Pupil-Entityklasse aus der mit JPA eine Datenbanktabelle erzeugt wird.
 * @author Tobias Riegel
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Pupil extends Person implements IPupil {
	
	
	private static final long serialVersionUID = 3461606884540372275L;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Course.class)
	@JoinColumn(name="course_FK")
	private ICourse course;
	
	public Pupil() {
		super();
	}

	public Pupil(int personID, String name, String firstname, String password, char gender, ICourse course) {
		super(personID, name, firstname, password, gender);
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
