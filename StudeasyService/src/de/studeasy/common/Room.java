package de.studeasy.common;

import java.io.Serializable;
import java.util.ArrayList;

import de.studeasy.entities.Lesson;

public interface Room extends Serializable {
	
	public String getRoomID();
	public void setRoomID(String roomID);
	public ArrayList<Lesson> getLessons();
	public void setLessons(ArrayList<Lesson> lessons);
}
