package de.studeasy.common;

import java.io.Serializable;
import java.util.Date;

import de.studeasy.entities.Homework;
import de.studeasy.entities.Room;
import de.studeasy.entities.Subject;
import de.studeasy.entities.Teacher;

public interface Lesson extends Serializable {
	
	public int getLessonID();
	public void setLessonID(int lessonID);
	public int getLessonHour();
	public void setLessonHour(int lessonHour);
	public Date getDate();
	public void setDate(Date date);
	public Teacher getTeacher();
	public void setTeacher(Teacher teacher);
	public Subject getSubject();
	public void setSubject(Subject subject);
	public Room getRoom();
	public void setRoom(Room room);
	public Homework getHomework();
	public void setHomework(Homework homework);

}
