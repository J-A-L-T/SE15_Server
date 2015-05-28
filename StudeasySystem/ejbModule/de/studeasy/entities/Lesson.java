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
	private ArrayList<Homework> homeworks;
	
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
	public ArrayList<Homework> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(ArrayList<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void addHomework(Homework homework) {
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
