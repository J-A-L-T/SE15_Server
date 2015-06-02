package de.studeasy.entities;

import java.io.Serializable;


import de.studeasy.common.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import de.studeasy.registries.LessonRegistry;

@Entity
public class Lesson implements Serializable, ILesson {
	
	private static final long serialVersionUID = -7694338591615228808L;
	
	@Id
	@GeneratedValue
	private int lessonID;
	private int lessonHour;
	private Date date;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private ICourse course;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private ITeacher teacher;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="subject_FK",
				unique=false)
	private ISubject subject;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private IRoom room;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="lesson_FK")
	private ArrayList<IHomework> homeworks;
	
	public Lesson() {
		LessonRegistry.getInstance().addLesson(this);
	}
	
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
	public ITeacher getTeacher() {
		return teacher;
	}
	public void setTeacher(ITeacher teacher) {
		this.teacher = teacher;
	}
	public ISubject getSubject() {
		return subject;
	}
	public void setSubject(ISubject subject) {
		this.subject = subject;
	}
	public IRoom getRoom() {
		return room;
	}
	public void setRoom(IRoom room) {
		this.room = room;
	}
	public ArrayList<IHomework> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(ArrayList<IHomework> homeworks) {
		this.homeworks = homeworks;
	}
	public ICourse getCourse() {
		return course;
	}
	public void setCourse(ICourse course) {
		this.course = course;
	}
	public void addHomework(String description) {
		IHomework homework = new Homework();
		//bisher ist ID noch standardmäßig 1 (nacher GeneratedValue)
		homework.setHomeworkID(1);
		homework.setDescription(description);
		homework.setLesson(this);
		this.homeworks.add(homework);
	}
	/**
	 * @return true=successful
	 */
	public boolean removeHomework(int homeworkID) {
		for(int i = 0; i < homeworks.size(); i++) {
			if(homeworks.get(i).getHomeworkID() == homeworkID) {
				homeworks.remove(i);
				return true;
			}
		}
		return false;
	}
}
