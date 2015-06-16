package de.studeasy.systeminterfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Interface für die Room-Entity
 * @author Andreas Prischep
 *
 */
public interface IRoom extends Serializable {
	
	public String getRoomID();
	public void setRoomID(String roomID);
	public List<ILesson> getLessons();
	public void setLessons(List<ILesson> lessons);
	public void addNewLesson(ILesson newLesson);
}
