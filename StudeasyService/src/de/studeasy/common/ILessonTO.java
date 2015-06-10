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
	public ITeacherTO getTeacher();
	public void setTeacher(ITeacherTO teacher);
	public ISubjectTO getSubject();
	public void setSubject(ISubjectTO subject);
	public IRoomTO getRoom();
	public void setRoom(IRoomTO room);
	public ArrayList<IHomeworkTO> getHomeworks();
	public void setHomeworks(ArrayList<IHomeworkTO> homeworks);
	public ICourseTO getCourse();
	public void setCourse(ICourseTO course);
	
}
