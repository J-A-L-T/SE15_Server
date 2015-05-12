package de.studeasy.entities;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="personID")
public class Pupil extends Person {
	
	private String password;
	
	public Pupil() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
