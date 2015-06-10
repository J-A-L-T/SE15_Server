package de.studeasy.common;

import java.util.Date;
import java.util.List;

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
	public List<IHomeworkTO> getHomeworks();
	public void setHomeworks(List<IHomeworkTO> list);
	public ICourseTO getCourse();
	public void setCourse(ICourseTO course);
	
}
