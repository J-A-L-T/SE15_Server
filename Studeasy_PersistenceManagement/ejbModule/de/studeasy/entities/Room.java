package de.studeasy.entities;

import java.io.Serializable;


import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IRoom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Room-Entityklasse aus der mit JPA eine Datenbanktabelle erzeugt wird.
 * @author Tobias Riegel
 *
 */
@Entity
public class Room implements Serializable, IRoom {

	private static final long serialVersionUID = 2206874152902693717L;

	@Id
	private String roomID;
	
	@OneToMany(cascade=CascadeType.ALL,
			   mappedBy="room",
			   targetEntity=Lesson.class)
	private List<ILesson> lessons;
	
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

	public List<ILesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<ILesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public void addNewLesson(ILesson newLesson) {
		this.lessons.add(newLesson);
	}
}
