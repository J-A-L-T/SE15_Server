package de.studeasy.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import de.studeasy.entities.Course;
import de.studeasy.entities.Homework;
import de.studeasy.entities.Room;
import de.studeasy.entities.Subject;
import de.studeasy.entities.Teacher;

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
	public ArrayList<IHomework> getHomeworks();
	public void setHomeworks(ArrayList<IHomework> homework);
	public ICourse getCourse();
	public void setCourse(ICourse course);
	public void addHomework(String description);
	public boolean removeHomework(int homeworkID);
}
