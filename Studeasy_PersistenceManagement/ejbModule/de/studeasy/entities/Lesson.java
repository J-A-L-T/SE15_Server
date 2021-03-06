package de.studeasy.entities;

import java.io.Serializable;


import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.IHomework;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IRoom;
import de.studeasy.systeminterfaces.ISubject;
import de.studeasy.systeminterfaces.ITeacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Lesson-Entityklasse aus der mit JPA eine Datenbanktabelle erzeugt wird.
 * @author Tobias Riegel
 *
 */
@Entity
public class Lesson implements Serializable, ILesson {
	
	private static final long serialVersionUID = -7694338591615228808L;
	
	@Id
	@GeneratedValue
	private int lessonID;
	private int lessonHour;
	private Date date;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Course.class)
	@JoinColumn(name="course_FK")
	private ICourse course;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Teacher.class)
	@JoinColumn(name="teacher_FK")
	private ITeacher teacher;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=Subject.class)
	@JoinColumn(name="subject_FK",
				unique=false)
	private ISubject subject;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Room.class)
	@JoinColumn(name="room_FK")
	private IRoom room;
	
	@OneToMany(cascade=CascadeType.ALL, 
			   targetEntity=Homework.class,
			   mappedBy="lesson")
	private List<IHomework> homeworks;
	
	public Lesson() {
		super();
	}
		
	public Lesson(int lessonHour, Date date, ICourse course, ITeacher teacher,
			ISubject subject, IRoom room) {
		super();
		this.lessonHour = lessonHour;
		this.date = date;
		
		this.course = course;
		this.course.addNewLesson(this);
		
		this.teacher = teacher;
		this.teacher.addNewLesson(this);
		
		this.subject = subject;
		
		this.room = room;
		this.room.addNewLesson(this);
		
		this.homeworks = new ArrayList<IHomework>();
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
	public List<IHomework> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(List<IHomework> homeworks) {
		this.homeworks = homeworks;
	}
	public ICourse getCourse() {
		return course;
	}
	public void setCourse(ICourse course) {
		this.course = course;
	}
	public void addNewHomework(IHomework homework) {
		this.homeworks.add(homework);
	}
	/**
	public boolean removeHomework(int homeworkID) {
		for(int i = 0; i < homeworks.size(); i++) {
			if(homeworks.get(i).getHomeworkID() == homeworkID) {
				homeworks.remove(i);
				return true;
			}
		}
		return false;
	}**/
}
