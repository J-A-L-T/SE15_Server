package de.studeasy.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IRoomTO extends Serializable {
	
	public String getRoomID();
	public void setRoomID(String roomID);
	public List<ILesson> getLessons();
	public void setLessons(ArrayList<ILesson> lessons);
}
