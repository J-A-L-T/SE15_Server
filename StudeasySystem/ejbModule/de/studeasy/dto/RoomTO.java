package de.studeasy.dto;

import java.io.Serializable;


import de.studeasy.common.*;
import java.util.List;

public class RoomTO implements Serializable, IRoomTO {

	private static final long serialVersionUID = 2206874152902693717L;


	private String roomID;
	

	private List<ILessonTO> lessons;

	
	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public List<ILessonTO> getLessons() {
		return lessons;
	}

	public void setLessons(List<ILessonTO> lessons) {
		this.lessons = lessons;
	}
}
