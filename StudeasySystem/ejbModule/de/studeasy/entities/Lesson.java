package de.studeasy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import de.studeasy.registries.LessonRegistry;

@Entity
public class Lesson implements Serializable, de.studeasy.common.Lesson {
	
	private static final long serialVersionUID = -7694338591615228808L;
	
	@Id
	@GeneratedValue
	private int lessonID;
	private int lessonHour;
	private Date date;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Course course;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Teacher teacher;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="subject_FK",
				unique=false)
	private Subject subject;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Room room;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="lesson_FK")
	private ArrayList<Homework> homework;
	
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public ArrayList<Homework> getHomework() {
		return homework;
	}
	public void setHomework(ArrayList<Homework> homework) {
		this.homework = homework;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
