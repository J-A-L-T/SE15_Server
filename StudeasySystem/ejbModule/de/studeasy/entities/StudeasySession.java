package de.studeasy.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class StudeasySession {

	@Id @GeneratedValue
	private int id;
	private int username;
	private Date creationTime;
	
	public StudeasySession(Person user) {
		this.username = user.getPersonID();
		this.creationTime = new Date();
	}
	
	public StudeasySession() {
		this.creationTime = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsername() {
		return this.username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
