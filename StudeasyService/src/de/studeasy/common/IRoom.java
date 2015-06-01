package de.studeasy.common;

import java.io.Serializable;
import java.util.ArrayList;

import de.studeasy.entities.Lesson;

public interface IRoom extends Serializable {
	
	public String getRoomID();
	public void setRoomID(String roomID);
	public ArrayList<ILesson> getLessons();
	public void setLessons(ArrayList<ILesson> lessons);
}