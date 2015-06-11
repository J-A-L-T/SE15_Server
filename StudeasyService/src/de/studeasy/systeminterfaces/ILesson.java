package de.studeasy.systeminterfaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ILesson extends Serializable {
	
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
	public List<IHomework> getHomeworks();
	public void setHomeworks(ArrayList<IHomework> homework);
	public ICourse getCourse();
	public void setCourse(ICourse course);
	public void addNewHomework(IHomework homework);
}
