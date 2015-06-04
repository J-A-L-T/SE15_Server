package de.studeasy.entities;

import java.io.Serializable;

import de.studeasy.common.*;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Room implements Serializable, IRoom {

	private static final long serialVersionUID = 2206874152902693717L;

	@Id
	@GeneratedValue
	private String roomID;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="room")
	@JoinColumn(name="room_FK")
	private ArrayList<ILesson> lessons;
	
	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public ArrayList<ILesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<ILesson> lessons) {
		this.lessons = lessons;
	}
}
