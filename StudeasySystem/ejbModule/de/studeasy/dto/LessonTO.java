package de.studeasy.dto;

import java.io.Serializable;
import de.studeasy.common.*;
import java.util.Date;
import java.util.List;

public class LessonTO implements Serializable, ILessonTO {
	
	private static final long serialVersionUID = -7694338591615228808L;
	

	private int lessonID;
	private int lessonHour;
	private Date date;
	

	private ICourseTO course;
	private ITeacherTO teacher;
	private ISubjectTO subject;
	private IRoomTO room;
	private List<IHomeworkTO> homeworks;
	public int getLessonID() {
		return lessonID;
	}
	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}
	public int getLessonHour() {
		return lessonHour;
	}
	public void setLessonHour(int lessonHour) {
		this.lessonHour = lessonHour;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ICourseTO getCourse() {
		return course;
	}
	public void setCourse(ICourseTO course) {
		this.course = course;
	}
	public ITeacherTO getTeacher() {
		return teacher;
	}
	public void setTeacher(ITeacherTO teacher) {
		this.teacher = teacher;
	}
	public ISubjectTO getSubject() {
		return subject;
	}
	public void setSubject(ISubjectTO subject) {
		this.subject = subject;
	}
	public IRoomTO getRoom() {
		return room;
	}
	public void setRoom(IRoomTO room) {
		this.room = room;
	}
	public List<IHomeworkTO> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(List<IHomeworkTO> homeworks) {
		this.homeworks = homeworks;
	}
	
}
