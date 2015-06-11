package de.studeasy.common;

import java.util.ArrayList;
import java.util.Date;

public interface ILessonTO {

	public int getLessonID();	
	public void setLessonID(int lessonID);
	public int getLessonHour();
	public void setLessonHour(int lessonHour);
	public Date getDate();
	public void setDate(Date date);
	public ITeacher getTeacher();
	public void setTeacher(ITeacher teacher);
	public ISubject getSubject();
	public void setSubject(ISubject subject);
	public IRoom getRoom();
	public void setRoom(IRoom room);
	public ArrayList<IHomework> getHomeworks();
	public void setHomeworks(ArrayList<IHomework> homeworks);
	public ICourse getCourse();
	public void setCourse(ICourse course);
	
}
