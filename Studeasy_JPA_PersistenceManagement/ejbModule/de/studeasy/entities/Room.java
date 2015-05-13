package de.studeasy.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Room implements Serializable{

	private String roomID;

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
}
