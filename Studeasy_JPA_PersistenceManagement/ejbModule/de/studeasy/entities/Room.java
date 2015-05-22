package de.studeasy.entities;

import java.io.Serializable;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Room implements Serializable{

	private static final long serialVersionUID = 2206874152902693717L;

	@Id
	@GeneratedValue
	private String roomID;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="room")
	@JoinColumn(name="room_FK")
	private ArrayList<Lesson> lessons;

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}
}
