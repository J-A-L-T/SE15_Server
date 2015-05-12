package de.studeasy.entities;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Teacher extends Person {
	
	public Teacher() {
		super();
	}
}
