package de.studeasy.entities;

import java.io.Serializable;

import de.studeasy.common.*;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Room implements Serializable, IRoom {

	private static final long serialVersionUID = 2206874152902693717L;

	@Id
	private String roomID;
	
	@OneToMany(cascade=CascadeType.PERSIST,
			   mappedBy="room")
	@JoinColumn(name="room_FK")
	private ArrayList<ILesson> lessons;
	
	public Room() {
		super();
	}

	//roomID muss übergeben werden, da hier kein GeneratedValue
	//Raumbezeichnungen in einem Gebäude sind schon unique
	public Room(String roomID) {
		super();
		this.roomID = roomID;
		this.lessons = new ArrayList<ILesson>();
	}

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

	@Override
	public void addNewLesson(ILesson newLesson) {
		this.lessons.add(newLesson);
	}
}
