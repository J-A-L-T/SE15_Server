package de.studeasy.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import de.studeasy.common.IPerson;


@Entity
public class StudeasySession {

	@Id @GeneratedValue
	private int id;
	private int userID;
	private Date creationTime;
	
	public StudeasySession(IPerson user) {
		this.userID = user.getPersonID();
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

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
